package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.barnacle.Const;
import de.arthurpicht.barnacle.configuration.BarnacleConfiguration;
import de.arthurpicht.barnacle.configuration.db.DbConnectionConfiguration;
import de.arthurpicht.barnacle.configuration.generator.GeneratorConfiguration;
import de.arthurpicht.barnacle.configuration.generator.GeneratorConfigurationBuilder;
import de.arthurpicht.utils.test.TestIds;

import java.util.ArrayList;
import java.util.List;

public class BarnacleConfigCreator {

    public static BarnacleConfiguration create(Object testCase) {
        GeneratorConfiguration generatorConfiguration = createGeneratorConfiguration(testCase);
        List<DbConnectionConfiguration> dbConnectionConfigurationList = new ArrayList<>();
        return new BarnacleConfiguration(generatorConfiguration, dbConnectionConfigurationList);
    }

    private static GeneratorConfiguration createGeneratorConfiguration(Object testCase) {
        String testGroupId = TestIds.getTestGroupId(testCase);
        String testCaseId = TestIds.getTestCaseId(testCase);

        GeneratorConfigurationBuilder generatorConfigurationBuilder = new GeneratorConfigurationBuilder(
                "de.arthurpicht.barnacleGeneratorTest." + testGroupId + "." + testCaseId + ".persistence.vof",
                "de.arthurpicht.barnacleGeneratorTest." + testGroupId + "." + testCaseId + ".persistence.vo",
                "de.arthurpicht.barnacleGeneratorTest." + testGroupId + "." + testCaseId + ".persistence.vob",
                "de.arthurpicht.barnacleGeneratorTest." + testGroupId + "." + testCaseId + ".persistence.dao"
        );
        generatorConfigurationBuilder.withDialect(Const.Dialect.H2);
        generatorConfigurationBuilder.withSrcDir("src/main/java");
        generatorConfigurationBuilder.withSrcGenDir("src/main/java-gen");
        generatorConfigurationBuilder.withExecuteOnDb(false);
        generatorConfigurationBuilder.withCreateScript(true);
        generatorConfigurationBuilder.withScriptFile(
                "src/main/java-gen/de/arthurpicht/barnacleGeneratorTest/" + testGroupId + "/" + testCaseId + "/sql/test.sql"
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
        generatorConfigurationBuilder.withOmitJavaDoc();

        return generatorConfigurationBuilder.build();
    }

}
