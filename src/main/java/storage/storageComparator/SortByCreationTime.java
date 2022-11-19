package storage.storageComparator;

import java.util.Comparator;

public interface SortByCreationTime<T> extends Comparator<T> {

    @Override
    int compare(T s1, T s2);
}
