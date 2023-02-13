package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths {

    public static String getBarnacleConf(String testCase) {
        Path path = getTestCaseDir(testCase).resolve("config/barnacle.conf");
        assertFileExists(path);
        return path.toAbsolutePath().toString();
    }

    public static String getSql(String testCase) {
        Path path = getJavaGenTestCaseDir(testCase).resolve("sql/test.sql");
        assertFileExists(path);
        return path.toAbsolutePath().toString();
    }

    public static String getSqlExpected(String testCase) {
        Path path = getTestCaseDir(testCase).resolve("sql/test.expected.sql");
        assertFileExists(path);
        return path.toAbsolutePath().toString();
    }

    public static Path getTestCaseDir(String testCase) {
        return Paths.get("src/test/java/de/arthurpicht/barnacleGeneratorTest/" + testCase);
    }

    public static Path getJavaGenTestCaseDir(String testCase) {
        Path javaGenPath = getJavaGenDir();
        assertDirExists(javaGenPath);
        return javaGenPath.resolve("de/arthurpicht/barnacleGeneratorTest/" + testCase);
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
