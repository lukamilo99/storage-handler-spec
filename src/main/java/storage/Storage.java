package storage;

import java.util.List;

public interface Storage{
    Object createDirectory(String path, String name, int numOfFilesInDir);
    Object createDirectories(String path, int numberOfDirectories);
    Object createFile(String path, String name);
    Object createFiles(String path, int numberOfDirectories);
    Object deleteFile(String path);
    Object deleteDirectory(String path);
    Object deleteAllFilesFromDirectory(String path);
    Object deleteAllDirectoriesFromParentDirectory(String path);
    Object deleteAllFromDirectory(String path);
    Object moveFile(List<String> path, String destinationPath);
    Object saveFile(String path);
    Object renameFile(String path);
    String getFilesFromDirectory(String directoryPath);
    String getFilesFromSubdirectories(String directoryPath);
    String getFilesFromDirectoryAndSubdirectories(String directoryPath);
    String getFilesWithExtensionFromDirectory(String directoryPath, FileExtension fileExtension);
    String getFilesThatContainsStringFromDirectory(String directoryPath, String contains);
    boolean containsFileWithName(String directoryPath, List<String> listOfNames);
    String getParentDirectoryOfFile(String filePath);
    String getFilesInPeriod(String directoryPath, String from, String to);
}
