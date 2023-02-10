package storage.components;

import storage.exceptions.ExtensionNotAllowedException;
import storage.exceptions.NotEnoughSpaceException;
import storage.exceptions.TooManyFilesException;

import java.util.List;

public interface Storage{
    void createDirectory(String path, String name, int numOfFilesInDir) throws TooManyFilesException, NotEnoughSpaceException;
    void createDirectories(String path, int numberOfDirectories) throws TooManyFilesException, NotEnoughSpaceException;
    void createFile(String path, String name) throws ExtensionNotAllowedException, TooManyFilesException, NotEnoughSpaceException;
    void createFiles(String path, int numberOfDirectories)  throws ExtensionNotAllowedException, TooManyFilesException, NotEnoughSpaceException;;
    void deleteFile(String path);
    void deleteAllFilesFromDirectory(String path);
    void deleteAllDirectoriesFromParentDirectory(String path);
    void deleteAllFromDirectory(String path);
    void moveFile(String path, String destinationPath) throws ExtensionNotAllowedException, TooManyFilesException, NotEnoughSpaceException;
    void uploadFile(List<String> files, String destinationPath) throws ExtensionNotAllowedException, TooManyFilesException, NotEnoughSpaceException;
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
