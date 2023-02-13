package de.arthurpicht.barnacleGeneratorTest.tc_01;

import de.arthurpicht.barnacle.GeneratorInit;
import de.arthurpicht.barnacleGeneratorTest.utils.CleanUp;
import de.arthurpicht.barnacleGeneratorTest.utils.Prepare;
import de.arthurpicht.barnacleGeneratorTest.utils.TestPaths;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase01 {

    private static final String testCase = "tc_01";

    @BeforeAll
    public static void prepare() throws IOException {
        CleanUp.cleanUp(testCase);
        Prepare.prepare(testCase);
    }

    @AfterAll
    public static void cleanUp() throws IOException {
//        CleanUp.cleanUp(testCase);
    }

    @Test
    @Order(1)
    public void generateSchema() throws IOException {
        System.setProperty(
                "barnacle.conf",
                TestPaths.getBarnacleConf(testCase));
        GeneratorInit.main(null);

        String sql = Files.readString(
                Paths.get(TestPaths.getSql(testCase)));
        String sqlExpected = Files.readString(
                Paths.get(TestPaths.getSqlExpected(testCase)));
        Assertions.assertEquals(sqlExpected, sql);

//        SchemaDeploy.deploy(testCase);
    }



}
