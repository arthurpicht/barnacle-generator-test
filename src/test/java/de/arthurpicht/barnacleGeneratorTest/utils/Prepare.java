package de.arthurpicht.barnacleGeneratorTest.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Prepare {

    public static void prepare(Object testCase) throws IOException {
        String testGroupId = TestIds.getTestGroupId(testCase);
        String testCaseId = TestIds.getTestCaseId(testCase);
        Path testCasePath = TestPaths.getJavaGenTestCaseDir(testGroupId, testCaseId);

        Files.createDirectories(testCasePath.resolve("persistence/dao"));
        Files.createDirectories(testCasePath.resolve("persistence/vo"));
        Files.createDirectories(testCasePath.resolve("sql"));
    }

}
