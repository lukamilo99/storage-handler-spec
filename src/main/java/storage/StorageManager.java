package storage;

import storage.components.AbstractStorage;

public class StorageManager {
    private static AbstractStorage storage;
    public static void registerStorage(AbstractStorage newStorage) {
        storage = newStorage;
    }
    public static AbstractStorage getStorage() {
        return storage;
    }
}
