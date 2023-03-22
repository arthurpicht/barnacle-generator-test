package de.arthurpicht.barnacleGeneratorTest.utils;

import de.arthurpicht.utils.io.nio2.FileUtils;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtilsLocal {

    public static List<Path> getSubdirectoriesStartingWith(Path dir, String start) throws IOException {
        List<Path> subDirs = FileUtils.getSubdirectories(dir);
        return subDirs.stream()
                .filter(p -> p.getFileName().toString().startsWith(start))
                .collect(Collectors.toList());
    }

    /**
     * Removes all regular files contained in specified directory (non-recursively).
     *
     * @param dir directory whose files are to be deleted
     * @throws IOException exception on deletion
     */
    public static void rmContainingRegularFilesFlat(Path dir) throws IOException {
        List<Path> fileList = FileUtils.getRegularFilesInDirectory(dir);
        for (Path file : fileList) {
            Files.deleteIfExists(file);
        }
    }

    /**
     * Copies specified regular file to destination folder.
     *
     * @param sourceFile regular file to be copied
     * @param destinationDir destination directory
     * @param copyOptions @see java.nio.file.CopyOption
     * @throws IOException exception on copy
     */
    public static void copyFile(Path sourceFile, Path destinationDir, CopyOption... copyOptions) throws IOException {
        if (!FileUtils.isExistingRegularFile(sourceFile))
            throw new IllegalArgumentException("File not found: [" + sourceFile.toAbsolutePath() + "].");
        if (!FileUtils.isExistingDirectory(destinationDir))
            throw new IllegalArgumentException("Directory not found: [" + destinationDir.toAbsolutePath() + "].");
        Path targetFile = destinationDir.resolve(sourceFile.getFileName());
        Files.copy(sourceFile, targetFile, copyOptions);
    }

    public static void copyFileWithAddedPostfix(Path sourceFile, Path destinationDir, String postfix, CopyOption... copyOptions) throws IOException {
        if (!FileUtils.isExistingRegularFile(sourceFile))
            throw new IllegalArgumentException("File not found: [" + sourceFile.toAbsolutePath() + "].");
        if (!FileUtils.isExistingDirectory(destinationDir))
            throw new IllegalArgumentException("Directory not found: [" + destinationDir.toAbsolutePath() + "].");
        Path targetFile = destinationDir.resolve(sourceFile.getFileName().toString() + postfix);
        Files.copy(sourceFile, targetFile, copyOptions);
    }

    public static void copyFilesWithAddedPostfix(List<Path> sourceFiles, Path destinationDir, String postfix, CopyOption... copyOptions) throws IOException {
        for (Path file : sourceFiles) {
            copyFileWithAddedPostfix(file, destinationDir, postfix, copyOptions);
        }
    }

}
