package storage.storageComponents;

import java.util.List;

public interface Storage{
    void createDirectory(String path, String name, int numOfFilesInDir);
    void createDirectories(String path, int numberOfDirectories);
    void createFile(String path, String name);
    void createFiles(String path, int numberOfDirectories);
    void deleteFile(String path);
    void deleteDirectory(String path);
    void deleteAllFilesFromDirectory(String path);
    void deleteAllDirectoriesFromParentDirectory(String path);
    void deleteAllFromDirectory(String path);
    void moveFile(String path, String destinationPath);
    void uploadFile(List<String> files, String destinationPath);
    void saveFile(String path, String downloadPath);
    void renameFile(String path, String newName);
    String getFilesFromDirectory(String directoryPath, String filter);
    String getFilesFromSubdirectories(String directoryPath, String filter);
    String getFilesFromDirectoryAndSubdirectories(String directoryPath, String filter);
    String getFilesWithExtensionFromDirectory(String directoryPath, FileExtension fileExtension, String filter);
    String getFilesThatContainsStringFromDirectory(String directoryPath, String contains, String filter);
    boolean containsFileWithName(String directoryPath, List<String> listOfNames);
    String getParentDirectoryOfFile(String filePath, String filter);
    String getFilesInPeriod(String directoryPath, String from, String to, String filter);
}
