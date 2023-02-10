package storage.components;

import lombok.Getter;
import java.util.Map;

@Getter
public abstract class AbstractStorage implements Storage{
    private Configuration configuration;
    private StorageFilter filter;
    private final String rootDirectory;
    private final StorageChecker checker;

    protected AbstractStorage(String path) {
        this.rootDirectory = path;
        this.configuration = new Configuration();
        this.checker = new StorageChecker(configuration);
    }

    public void setConfiguration(long sizeOfStorage, Map<FileExtension, Boolean> fileExtensionBooleanMap){
        this.configuration.setStorageSize(sizeOfStorage);
        this.configuration.setRemainingStorageSize(sizeOfStorage);
        this.configuration.setAllowedExtensionMap(fileExtensionBooleanMap);
    }

    public void setFilter(StorageFilter filter){
        this.filter = filter;
    }

    public void setUtilsForChecker(StorageUtils storageUtils){
        this.checker.setStorageUtils(storageUtils);
    }
    protected abstract void createJSONConfigurationFile(String path);
}
