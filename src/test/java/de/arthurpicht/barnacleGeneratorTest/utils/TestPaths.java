package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class TestPaths {

//    public static String getBarnacleConf(String testCase) {
//        Path path = getTestCaseDir(testCase).resolve("config/barnacle.conf");
//        assertFileExists(path);
//        return path.toAbsolutePath().toString();
//    }

    public static Path getSql(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        String testGroupId = TestUtils.getTestGroupId(canonicalName);
        String testCaseId = TestUtils.getTestCaseId(canonicalName);
        Path path = getJavaGenTestCaseDir(testGroupId, testCaseId).resolve("sql/test.sql");
        assertFileExists(path);
        return path;
    }

    public static Path getSqlExpected(Object testCase) {
        Path testCaseDir = TestUtils.getTestCaseDir(testCase);
        Path path = testCaseDir.resolve("expected/sql/test.expected.sql");
        assertFileExists(path);
        return path;
    }

    public static Path getTestCaseDir(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        Path path = TestUtils.getTestCaseDir(testCase);
        return Paths.get("src/test/java/de/arthurpicht/barnacleGeneratorTest/" + testCase);
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

}
