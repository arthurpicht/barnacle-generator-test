package de.arthurpicht.barnacleGeneratorTest.utils.prepareExpected;

import de.arthurpicht.barnacleGeneratorTest.utils.FileUtilsLocal;
import de.arthurpicht.barnacleGeneratorTest.utils.TestPaths;
import de.arthurpicht.utils.io.nio2.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CopyExpected {

    public static void copy(TestCaseIds testCaseIds) throws IOException {
        copy(testCaseIds.getTestGroupId(), testCaseIds.getTestCaseId());
    }

    public static void copy(String testGroupId, String testCaseId) throws IOException {
        Path persistenceDir = TestPaths.getJavaGenTestCasePersistenceDir(testGroupId, testCaseId);
        Path daoDir = persistenceDir.resolve("dao");
        List<Path> daoFiles = FileUtils.getRegularFilesInDirectory(daoDir);
        Path voDir = persistenceDir.resolve("vo");
        List<Path> voFiles = FileUtils.getRegularFilesInDirectory(voDir);

        Path persistenceExpectedDir = TestPaths.getTestCaseDir(testGroupId, testCaseId).resolve("expected/persistence");
        Path expectedDaoDir = persistenceExpectedDir.resolve("dao");
        Files.createDirectories(expectedDaoDir);
        FileUtilsLocal.rmContainingRegularFilesFlat(expectedDaoDir);

        Path expectedVoDir = persistenceExpectedDir.resolve("vo");
        Files.createDirectories(expectedVoDir);
        FileUtilsLocal.rmContainingRegularFilesFlat(expectedVoDir);

        FileUtilsLocal.copyFilesWithAddedPostfix(daoFiles, expectedDaoDir, ".expected");
        FileUtilsLocal.copyFilesWithAddedPostfix(voFiles, expectedVoDir, ".expected");
    }

    public static void copyAll() throws IOException {
        System.out.println("copy all...");
        List<TestCaseIds> testCaseIdsList = TestCaseIdsFinder.findAll();
        System.out.println("found testCaseIds");
        for (TestCaseIds testCaseIds : testCaseIdsList) {
            System.out.println(testCaseIds);
            copy(testCaseIds);
        }
    }

    public static void main(String[] args) throws IOException {
        copyAll();
//        copy("tg_01", "tc_01");
    }

}
