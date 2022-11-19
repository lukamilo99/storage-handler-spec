package storage.storageComparator;

import java.util.Comparator;

public interface SortByLastModifiedTime<T>extends Comparator<T> {
    @Override
    int compare(T o1, T o2);
}
