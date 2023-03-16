package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths {

    public static Path getSql(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        String testGroupId = TestUtils.getTestGroupId(canonicalName);
        String testCaseId = TestUtils.getTestCaseId(canonicalName);
        Path path = getJavaGenTestCaseDir(testGroupId, testCaseId).resolve("sql/test.sql");
        assertFileExists(path);
        return path;
    }

    public static Path getSqlExpected(Object testCase) {
        Path testCaseDir = getTestCaseDir(testCase);
        Path path = testCaseDir.resolve("expected/sql/test.expected.sql");
        assertFileExists(path);
        return path;
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
}
