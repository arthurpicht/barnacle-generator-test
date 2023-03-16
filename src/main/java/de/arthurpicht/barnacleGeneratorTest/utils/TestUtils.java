package de.arthurpicht.barnacleGeneratorTest.utils;

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

}
