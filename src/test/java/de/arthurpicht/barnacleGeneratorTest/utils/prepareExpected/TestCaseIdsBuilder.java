package de.arthurpicht.barnacleGeneratorTest.utils.prepareExpected;

import de.arthurpicht.utils.test.TestIds;
import java.nio.file.Path;

public class TestCaseIdsBuilder {

    public static TestCaseIds build(Path testCaseDir) {
        String testGroupId = TestIds.getTestGroupId(testCaseDir);
        String testCaseId = TestIds.getTestCaseId(testCaseDir);
        return new TestCaseIds(testGroupId, testCaseId);
    }

}
