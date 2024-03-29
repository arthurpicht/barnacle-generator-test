package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;
import de.arthurpicht.utils.test.TestIds;

import java.nio.file.Path;

public class CleanUp {

    public static void cleanUp(Object testCase) {
        String testGroupId = TestIds.getTestGroupId(testCase);
        String testCaseId = TestIds.getTestCaseId(testCase);
        Path testCasePath = TestPaths.getJavaGenTestCaseDir(testGroupId, testCaseId);
        FileUtils.rmDirSilently(testCasePath);
    }

}
