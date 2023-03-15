package de.arthurpicht.barnacleGeneratorTest.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {

    private static final Pattern patternTestGroup = Pattern.compile("tg_\\d+");
    private static final Pattern patternTestCase = Pattern.compile("tc_\\d+");

    public static String getTestGroupId(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        return getTestGroupId(canonicalName);
    }

    public static String getTestGroupId(String canonicalName) {
        Matcher matcher = patternTestGroup.matcher(canonicalName);
        if (!matcher.find())
            throw new IllegalArgumentException("No test group found for class " + canonicalName);
        return matcher.group();
    }

    public static String getTestCaseId(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        return getTestCaseId(canonicalName);
    }

    public static String getTestCaseId(String canonicalName) {
        Matcher matcher = patternTestCase.matcher(canonicalName);
        if (!matcher.find())
            throw new IllegalArgumentException("No test case found for class " + canonicalName);
        return matcher.group();
    }

    public static Path getTestCaseDir(Object testCase) {
        String canonicalName = testCase.getClass().getCanonicalName();
        return getTestCaseDir(canonicalName);
    }

    public static Path getTestCaseDir(String canonicalName) {
        String packageName = canonicalName.substring(0, canonicalName.lastIndexOf('.'));
        return Paths.get("src/test/java").resolve(packageName.replace('.', '/'));
    }

    @Test
    public void testTestGroup() {
        String string = "ein.zwei.tg_03_blahblah.tc_77_blub";
        String testGroupId = getTestGroupId(string);
        Assertions.assertEquals("tg_03", testGroupId);
    }

    @Test
    public void testTestCase() {
        String string = "ein.zwei.tg_03_blahblah.tc_77_blub";
        String testGroupId = getTestCaseId(string);
        Assertions.assertEquals("tc_77", testGroupId);
    }

//    @Test
//    public void testTestCasePackage() {
//        String string = "de.arthurpicht.test.MyTestClass";
//        String testCasePackage = getTestCaseDir(string);
//        Assertions.assertEquals("de.arthurpicht.test", testCasePackage);
//    }

}
