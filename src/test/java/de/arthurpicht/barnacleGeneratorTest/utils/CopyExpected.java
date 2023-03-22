package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CopyExpected {

    public static void copy(String testGroupId, String testCaseId) throws IOException {
        Path persistenceDir = TestPaths.getJavaGenTestCasePersistenceDir(testGroupId, testCaseId);
        Path daoDir = persistenceDir.resolve("dao");
        List<Path> daoFiles = FileUtils.getRegularFilesInDirectory(daoDir);
        Path voDir = persistenceDir.resolve("vo");
        List<Path> voFiles = FileUtils.getRegularFilesInDirectory(voDir);

        Path persistenceExpectedDir = TestPaths.getTestCaseDir(testGroupId, testCaseId).resolve("expected/persistence");
        Path expectedDaoDir = persistenceExpectedDir.resolve("dao");
        FileUtilsLocal.rmContainingRegularFilesFlat(expectedDaoDir);
        Path expectedVoDir = persistenceExpectedDir.resolve("vo");
        FileUtilsLocal.rmContainingRegularFilesFlat(expectedVoDir);

        FileUtilsLocal.copyFilesWithAddedPostfix(daoFiles, expectedDaoDir, ".expected");
        FileUtilsLocal.copyFilesWithAddedPostfix(voFiles, expectedVoDir, ".expected");
    }

    public static void main(String[] args) throws IOException {
        copy("tg_01", "tc_01");
    }

}
