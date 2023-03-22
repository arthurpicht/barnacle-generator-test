package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class TestPaths {

    public static Path getSql(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        String testGroupId = TestUtils.getTestGroupId(canonicalName);
        String testCaseId = TestUtils.getTestCaseId(canonicalName);
        Path path = getJavaGenTestCaseDir(testGroupId, testCaseId).resolve("sql/test.sql");
        assertFileExists(path);
        return path;
    }

    public static Path getExpectedPersistenceDir(Object testCase) {
        Path testCaseDir = getTestCaseDir(testCase);
        Path path = testCaseDir.resolve("expected/persistence");
        assertDirExists(path);
        return path;
    }

    public static Path getSqlExpected(Object testCase) {
        Path testCaseDir = getTestCaseDir(testCase);
        Path path = testCaseDir.resolve("expected/sql/test.expected.sql");
        assertFileExists(path);
        return path;
    }

    public static Path getJavaGenTestCasePersistenceDir(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        String testGroupId = TestUtils.getTestGroupId(canonicalName);
        String testCaseId = TestUtils.getTestCaseId(canonicalName);
        return getJavaGenTestCasePersistenceDir(testGroupId, testCaseId);
    }

    public static Path getJavaGenTestCasePersistenceDir(String testGroupId, String testCaseId) {
        return getJavaGenTestCaseDir(testGroupId, testCaseId).resolve("persistence");
    }

    public static Path getJavaGenTestCaseDir(String testGroupId, String testCaseId) {
        Path javaGenPath = getJavaGenDir();
        assertDirExists(javaGenPath);
        return javaGenPath.resolve("de/arthurpicht/barnacleGeneratorTest/" + testGroupId + "/" + testCaseId);
    }

    public static Path getJavaGenDir() {
        return Paths.get("src/main/java-gen");
    }

    private static void assertFileExists(Path path) {
        if (!FileUtils.isExistingRegularFile(path))
            throw new RuntimeException("File [" + path.toAbsolutePath() + "] not found.");
    }

    private static void assertDirExists(Path path) {
        if (!FileUtils.isExistingDirectory(path))
            throw new RuntimeException("Directory [" + path.toAbsolutePath() + "] not found.");
    }

    public static Path getTestCaseDir(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        return getTestCaseDir(canonicalName);
    }

    public static Path getTestCaseDir(String canonicalName) {
        String packageName = canonicalName.substring(0, canonicalName.lastIndexOf('.'));
        return Paths.get("src/test/java").resolve(packageName.replace('.', '/'));
    }

    public static Path getTestCaseDir(String testGroupId, String testCaseId) throws IOException {
        Path baseDir = Paths.get("src/test/java/de/arthurpicht/barnacleGeneratorTest");
        List<Path> testGroupSubDirs = FileUtilsLocal.getSubdirectoriesStartingWith(baseDir, testGroupId);
        if (testGroupSubDirs.isEmpty())
            throw new IllegalStateException("No directory found for testGroupId [" + testGroupId + "].");
        Path testGroupDir = testGroupSubDirs.get(0);
        List<Path> testCaseSubDirs = FileUtilsLocal.getSubdirectoriesStartingWith(testGroupDir, testCaseId);
        if (testCaseSubDirs.isEmpty())
            throw new IllegalStateException("No directory found for testGroupId/testCaseId " +
                    "[" + testGroupId + "][" + testCaseId + "].");
        return testCaseSubDirs.get(0);
    }

}
