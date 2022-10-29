package storage.comparator;

import java.nio.file.Path;
import java.util.Comparator;

public class SortByName implements Comparator<Path> {

    @Override
    public int compare(Path o1, Path o2) {
        return o1.getFileName().toString().compareTo(o2.getFileName().toString());
    }
}
