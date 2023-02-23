package de.arthurpicht.barnacleGeneratorTest.tc_02;

import de.arthurpicht.barnacle.BarnacleGeneratorStarter;
import de.arthurpicht.barnacle.context.GeneratorContext;
import de.arthurpicht.barnacleGeneratorTest.TestConfiguration;
import de.arthurpicht.barnacleGeneratorTest.utils.CleanUp;
import de.arthurpicht.barnacleGeneratorTest.utils.Prepare;
import de.arthurpicht.barnacleGeneratorTest.utils.TestPaths;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase02 {

    private static final String testCase = "tc_02";

    @BeforeAll
    public static void prepare() throws IOException {
        GeneratorContext.invalidate();
        CleanUp.cleanUp(testCase);
        Prepare.prepare(testCase);
    }

    @AfterAll
    public static void cleanUp() {
        if (TestConfiguration.cleanUpAfterEachExecution)
            CleanUp.cleanUp(testCase);
    }

    @Test
    @Order(1)
    public void generateSchema() throws IOException {
        System.setProperty(
                "barnacle.conf",
                TestPaths.getBarnacleConf(testCase));
        BarnacleGeneratorStarter.main(null);

        String sql = Files.readString(
                Paths.get(TestPaths.getSql(testCase)));
        String sqlExpected = Files.readString(
                Paths.get(TestPaths.getSqlExpected(testCase)));
        assertEquals(sqlExpected, sql);
    }

}
