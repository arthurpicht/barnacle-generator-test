package de.arthurpicht.barnacleGeneratorTest;

import de.arthurpicht.barnacle.configuration.generator.GeneratorConfiguration;
import de.arthurpicht.barnacle.context.GeneratorContext;
import de.arthurpicht.barnacle.generator.BarnacleGenerator;
import de.arthurpicht.barnacleGeneratorTest.utils.*;
import de.arthurpicht.barnacleGeneratorTest.utils.FilesCompare.FilePair;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class BaseTestCase {

    @BeforeAll
    public void prepare() throws IOException {
        GeneratorContext.invalidate();
        CleanUp.cleanUp(this);
        Prepare.prepare(this);
    }

    @AfterAll
    public void cleanUp() {
        if (TestConfiguration.cleanUpAfterEachExecution)
            CleanUp.cleanUp(this);
    }

    @Test
    @Order(1)
    public void generate() {
        GeneratorConfiguration generatorConfiguration = GeneratorConfigCreator.create(this);
        BarnacleGenerator.process(generatorConfiguration);
    }

    @Test
    @Order(2)
    public void checkDbSchema() throws IOException {
        String sql = Files.readString(TestPaths.getSql(this));
        String sqlExpected = Files.readString(TestPaths.getSqlExpected(this));
        assertEquals(sqlExpected, sql);
    }

    @Test
    @Order(3)
    public void checkGeneratedJavaFiles() throws IOException {
        Path testCaseGenPersistenceDir = TestPaths.getJavaGenTestCasePersistenceDir(this);
        Path expectedPersistenceDir = TestPaths.getExpectedPersistenceDir(this);
        FilesCompare filesCompare = new FilesCompare(expectedPersistenceDir, testCaseGenPersistenceDir, ".expected", false);
        for (FilePair filePair : filesCompare.getFilePairList()) {
            System.out.println("Checking: " + filePair);
            assertEquals(filePair.getExpectedFileAsString(), filePair.getTestFileAsString());
        }
    }

}
