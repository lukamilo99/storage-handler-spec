package storage.comparator;

import java.util.Comparator;

public interface SortBySize<T> extends Comparator<T> {
    @Override
    int compare(T o1, T o2);
}
