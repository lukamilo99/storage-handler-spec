package storage.storageComponents;

import lombok.Getter;

@Getter
public class StorageChecker {
    private StorageUtils storageUtils;

    public StorageChecker(){}

    public boolean checkExtension(String file, Configuration configuration) {
        if(configuration.getAllowedExtensionMap().get(storageUtils.getFileExtension(file)) == null) return true;
        return configuration.getAllowedExtensionMap().get(storageUtils.getFileExtension(file));
    }

    public boolean checkSize(String file, Configuration configuration) {
        if(configuration.getRemainingStorageSize() > storageUtils.getSizeOf(file)) return true;
        else return false;
    }

    public boolean checkNumberOfFileInDirectory(String directory, Configuration configuration) {
        return configuration.getNumberOfFilesInDirectoryMap().get(directory) > 0;
    }

    public void setStorageUtils(StorageUtils storageUtils){
        this.storageUtils = storageUtils;
    }
}
