package de.arthurpicht.barnacleGeneratorTest.utils.prepareExpected;

import de.arthurpicht.barnacleGeneratorTest.utils.TestIds;
import de.arthurpicht.utils.io.nio2.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCaseIdsFinder {

    public static List<TestCaseIds> findAll() throws IOException {
        Path rootPath = Paths.get("src/main/java/de/arthurpicht/barnacleGeneratorTest");
        List<Path> testCaseDirs = getAllTestCaseDirs(rootPath);
        return testCaseDirs.stream()
                .map(TestCaseIdsBuilder::build)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Path> getAllTestCaseDirs(Path rootPath) throws IOException {
        try (Stream<Path> pathStream = Files.walk(rootPath)) {
            return pathStream
                    .filter(FileUtils::isExistingDirectory)
                    .filter(TestIds::hasTestCaseId)
                    .collect(Collectors.toList());
        }
    }

}
