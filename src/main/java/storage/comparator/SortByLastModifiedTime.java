package storage.comparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

public class SortByLastModifiedTime implements Comparator<Path> {

    @Override
    public int compare(Path o1, Path o2) {
        try {
            BasicFileAttributes fileAttributes1 = Files.readAttributes(o1, BasicFileAttributes.class);
            BasicFileAttributes fileAttributes2 = Files.readAttributes(o2, BasicFileAttributes.class);

            return fileAttributes1.lastModifiedTime().compareTo(fileAttributes2.lastModifiedTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
