package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.nio.file.Path;

public class CleanUp {

    public static void cleanUp(Object testCase) {
        String testGroupId = TestUtils.getTestGroupId(testCase);
        String testCaseId = TestUtils.getTestCaseId(testCase);
        Path testCasePath = TestPaths.getJavaGenTestCaseDir(testGroupId, testCaseId);
        FileUtils.rmDirSilently(testCasePath);
    }

}
