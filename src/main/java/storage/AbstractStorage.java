package storage;

import com.google.gson.Gson;
import lombok.Getter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

@Getter
public abstract class AbstractStorage implements Storage{
    private final Configuration configuration;
    private final Path rootDirectory;
    private final StorageChecker storageChecker;

    public AbstractStorage(String path, Configuration configuration){
        this.rootDirectory = Paths.get(path);
        createRootDirectory();
        this.configuration = configuration;
        createJSONConfigurationFile(path);
        storageChecker = new StorageChecker();
    }

    public AbstractStorage(String path) {
        this.rootDirectory = Paths.get(path);
        createRootDirectory();
        this.configuration = new Configuration();
        createJSONConfigurationFile(path);
        storageChecker = new StorageChecker();
    }

    private void createRootDirectory(){
        try {
            Files.createDirectory(rootDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createJSONConfigurationFile(String path){
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(path.concat("\\config.json"))) {
            gson.toJson(configuration, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean check(Path file){
       return storageChecker.checkAll(file, configuration);
    }
}
