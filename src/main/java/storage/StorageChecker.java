package storage;

import java.nio.file.Files;
import java.nio.file.Path;

public class StorageChecker {

    public StorageChecker(){}

    public boolean checkAll(Path file, Configuration configuration){
        if(Files.isRegularFile(file)) checkExtension(file, configuration);
        if(Files.isDirectory(file)) checkNumberOfFileInDirectory(file.getParent(), configuration);
        checkSize(file, configuration);
        return true;
    }

    public boolean checkExtension(Path file, Configuration configuration){
        return configuration.getAllowedExtensionMap().get(StorageUtils.getFileExtension(file));
    }

    public boolean checkSize(Path file, Configuration configuration){
        if(StorageUtils.getSizeOf(file) > configuration.getRemainingStorageSize()) return false;
        else return true;
    }

    public boolean checkNumberOfFileInDirectory(Path file, Configuration configuration){
        if(configuration.getNumberOfFilesInDirectoryMap().get(file) == 0) return false;
        else return true;
    }
}
