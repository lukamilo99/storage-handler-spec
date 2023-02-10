package storage.components;

import lombok.Getter;

@Getter
public class StorageChecker {
    private StorageUtils storageUtils;
    private Configuration configuration;
    public StorageChecker(Configuration configuration){
        this.configuration = configuration;
    }

    public boolean checkExtension(String file) {
        if(configuration.getAllowedExtensionMap().get(storageUtils.getFileExtension(file)) == null) return true;
        return configuration.getAllowedExtensionMap().get(storageUtils.getFileExtension(file));
    }

    public boolean checkSize(String file) {
        if(configuration.getRemainingStorageSize() > storageUtils.getSizeOf(file)) return true;
        else return false;
    }

    public boolean checkNumberOfFileInDirectory(String directory) {
        return configuration.getNumberOfFilesInDirectoryMap().get(directory) > 0;
    }
    public void setStorageUtils(StorageUtils storageUtils){
        this.storageUtils = storageUtils;
    }
}
