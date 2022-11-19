package storage.storageComponents;

public abstract class StorageUtils {

    public abstract long getSizeOf(String file);

    public static FileExtension getFileExtension(String file){
        String fileExtension = file.substring(file.lastIndexOf(".") + 1).toUpperCase();
        return FileExtension.valueOf(fileExtension);
    }
}
