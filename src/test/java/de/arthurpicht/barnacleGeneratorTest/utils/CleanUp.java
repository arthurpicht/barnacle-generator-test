package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.nio.file.Path;

public class CleanUp {

    public static void cleanUp(String testCase) {
        Path testCasePath = TestPaths.getJavaGenTestCaseDir(testCase);
        FileUtils.rmDirSilently(testCasePath);
    }

}
