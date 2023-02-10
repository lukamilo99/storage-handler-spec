package storage.comparator;

import java.util.Comparator;

public interface AbstractComparatorFactory<T> {
    public Comparator<T> getComparator(String type);
}
