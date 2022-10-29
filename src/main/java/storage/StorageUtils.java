package storage;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class StorageUtils {

    public static long getSizeOf(Path path){
        AtomicLong size = new AtomicLong(0L);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                    size.addAndGet(attrs.size());

                    return FileVisitResult.TERMINATE;
                }
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc){
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return size.get();
    }

    public static FileExtension getFileExtension(Path file){
        String fileExtension = file.toString().substring(file.toString().lastIndexOf(".") + 1).toUpperCase();
        return FileExtension.valueOf(fileExtension);
    }
}
