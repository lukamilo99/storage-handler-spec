package storage;

import lombok.Getter;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Configuration {
    private long storageSize;
    private long remainingStorageSize;
    private Map<FileExtension, Boolean> allowedExtensionMap;
    private Map<Path, Integer> numberOfFilesInDirectoryMap;

    public Configuration(){
        this.storageSize = Long.MAX_VALUE;
        this.remainingStorageSize = storageSize;
        this.numberOfFilesInDirectoryMap = new HashMap<>();
        this.allowedExtensionMap = new HashMap<>();
        this.allowedExtensionMap.put(FileExtension.EXE, false);
    }

    public Configuration(long sizeOfStorage, List<String> unwantedExtensions){
        this.storageSize = sizeOfStorage;
        this.remainingStorageSize = storageSize;
        this.numberOfFilesInDirectoryMap = new HashMap<>();
        this.allowedExtensionMap = new HashMap<>();
        for(String extension: unwantedExtensions) {
            allowedExtensionMap.put(FileExtension.valueOf(extension), false);
        }
    }

    public void takeFromRemainingSize(long sizeOfFile){
        remainingStorageSize -= sizeOfFile;
    }

    public void takeFromNumberOfFile(Path path){
        numberOfFilesInDirectoryMap.put(path, numberOfFilesInDirectoryMap.get(path) - 1);
    }

    public void addToRemainingSize(long sizeOfFile){
        remainingStorageSize += sizeOfFile;
    }

    public void addToNumberOfFile(Path path){
        numberOfFilesInDirectoryMap.put(path, numberOfFilesInDirectoryMap.get(path) + 1);
    }
}
