package storage.storageComponents;

import lombok.Getter;
import java.util.Map;

@Getter
public abstract class AbstractStorage implements Storage{
    private Configuration configuration;
    private final String rootDirectory;
    private final StorageChecker storageChecker;

    protected AbstractStorage(String path) {
        this.rootDirectory = path;
        this.configuration = new Configuration();
        this.storageChecker = new StorageChecker();
    }

    public void setConfiguration(long sizeOfStorage, Map<FileExtension, Boolean> fileExtensionBooleanMap){
        this.configuration.setStorageSize(sizeOfStorage);
        this.configuration.setRemainingStorageSize(sizeOfStorage);
        this.configuration.setAllowedExtensionMap(fileExtensionBooleanMap);
    }

    protected abstract void createJSONConfigurationFile(String path);
}
