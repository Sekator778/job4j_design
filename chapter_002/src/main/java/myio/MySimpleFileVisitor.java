package myio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        String dirName = "/home/sekator";
        try {
            Files.walkFileTree(Paths.get(dirName), new MySimpleFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
