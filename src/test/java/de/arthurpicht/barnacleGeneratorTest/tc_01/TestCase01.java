//package de.arthurpicht.barnacleGeneratorTest.tc_01;
//
//import de.arthurpicht.barnacle.BarnacleGeneratorStarter;
//import de.arthurpicht.barnacle.configuration.generator.GeneratorConfiguration;
//import de.arthurpicht.barnacle.context.GeneratorContext;
//import de.arthurpicht.barnacle.generator.BarnacleGenerator;
//import de.arthurpicht.barnacleGeneratorTest.TestConfiguration;
//import de.arthurpicht.barnacleGeneratorTest.utils.CleanUp;
//import de.arthurpicht.barnacleGeneratorTest.utils.GeneratorConfigCreator;
//import de.arthurpicht.barnacleGeneratorTest.utils.Prepare;
//import de.arthurpicht.barnacleGeneratorTest.utils.TestPaths;
//import org.junit.jupiter.api.*;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class TestCase01 {
//
//    private static final String testCase = "tc_01";
//
//    @BeforeAll
//    public static void prepare() throws IOException {
//        GeneratorContext.invalidate();
//        CleanUp.cleanUp(testCase);
//        Prepare.prepare(testCase);
//    }
//
//    @AfterAll
//    public static void cleanUp() {
//        if (TestConfiguration.cleanUpAfterEachExecution)
//            CleanUp.cleanUp(testCase);
//    }
//
//    @Test
//    @Order(1)
//    public void generateSchema() throws IOException {
//        GeneratorConfiguration generatorConfiguration = GeneratorConfigCreator.create(testCase);
//        BarnacleGenerator.process(generatorConfiguration);
//
//        String sql = Files.readString(
//                Paths.get(TestPaths.getSql(testCase)));
//        String sqlExpected = Files.readString(
//                Paths.get(TestPaths.getSqlExpected(testCase)));
//        assertEquals(sqlExpected, sql);
//    }
//
//}
