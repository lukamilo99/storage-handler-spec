package storage.components;

import java.util.List;

public interface StorageFilter<T> {
    String filterData(List<T> fileList, String filter);
}
