package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.barnacle.Const;
import de.arthurpicht.barnacle.configuration.generator.GeneratorConfiguration;
import de.arthurpicht.barnacle.configuration.generator.GeneratorConfigurationBuilder;

public class GeneratorConfigCreator {

    public static GeneratorConfiguration create(String testCase) {
        GeneratorConfigurationBuilder generatorConfigurationBuilder = new GeneratorConfigurationBuilder(
                "de.arthurpicht.barnacleGeneratorTest." + testCase + ".persistence.vof",
                "de.arthurpicht.barnacleGeneratorTest." + testCase + ".persistence.vo",
                "de.arthurpicht.barnacleGeneratorTest." + testCase + ".persistence.vob",
                "de.arthurpicht.barnacleGeneratorTest." + testCase + ".persistence.dao"
        );
        generatorConfigurationBuilder.withDialect(Const.Dialect.H2);
        generatorConfigurationBuilder.withSrcDir("src/main/java");
        generatorConfigurationBuilder.withSrcGenDir("src/main/java-gen");
        generatorConfigurationBuilder.withExecuteOnDb(false);
        generatorConfigurationBuilder.withCreateScript(true);
        generatorConfigurationBuilder.withScriptFile(
                "src/main/java-gen/de/arthurpicht/barnacleGeneratorTest/" + testCase + "/sql/test.sql"
        );
        generatorConfigurationBuilder.withConnectionManagerCanonicalClassName(
                "de.arthurpicht.barnacleGeneratorTest.connectionManager.ConnectionManager"
        );
        generatorConfigurationBuilder.withConnectionExceptionCanonicalClassName(
                "de.arthurpicht.barnacleGeneratorTest.connectionManager.DataSourceException"
        );
        generatorConfigurationBuilder.withEntityNotFoundExceptionCanonicalClassName(
                "de.arthurpicht.barnacleGeneratorTest.connectionManager.EntityNotFoundException"
        );

        return generatorConfigurationBuilder.build();
    }

}
