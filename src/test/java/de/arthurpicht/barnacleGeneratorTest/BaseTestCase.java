package de.arthurpicht.barnacleGeneratorTest;

import de.arthurpicht.barnacle.configuration.generator.GeneratorConfiguration;
import de.arthurpicht.barnacle.context.GeneratorContext;
import de.arthurpicht.barnacle.generator.BarnacleGenerator;
import de.arthurpicht.barnacleGeneratorTest.utils.CleanUp;
import de.arthurpicht.barnacleGeneratorTest.utils.GeneratorConfigCreator;
import de.arthurpicht.barnacleGeneratorTest.utils.Prepare;
import de.arthurpicht.barnacleGeneratorTest.utils.TestPaths;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    public void generateSchema() throws IOException {
        GeneratorConfiguration generatorConfiguration = GeneratorConfigCreator.create(this);
        BarnacleGenerator.process(generatorConfiguration);

        String sql = Files.readString(TestPaths.getSql(this));
        String sqlExpected = Files.readString(TestPaths.getSqlExpected(this));
        assertEquals(sqlExpected, sql);
    }

}
