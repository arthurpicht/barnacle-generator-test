package de.arthurpicht.barnacleGeneratorTest.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Prepare {

    public static void prepare(String testCase) throws IOException {
        Path testCasePath = TestPaths.getJavaGenTestCaseDir(testCase);

        Files.createDirectories(testCasePath.resolve("persistence/dao"));
        Files.createDirectories(testCasePath.resolve("persistence/vo"));
        Files.createDirectories(testCasePath.resolve("sql"));
    }

}
