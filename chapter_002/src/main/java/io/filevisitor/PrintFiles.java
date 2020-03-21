package io.filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class PrintFiles implements FileVisitor<Path> {
    private String partOfName;
    public List<String> foundFiles;

    public PrintFiles(String partOfName) {
        this.partOfName = partOfName;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    /**
     * boolean isRegularFile(Path)	Путь – это файл?
     * @param file путь старта
     * @param attrs - кусок имени файла
     * @return - лист имен файлов оканчивающихся на attrs
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (!attrs.isRegularFile()) {
            return CONTINUE;
        }
        if (!file.getFileName().toString().endsWith(this.partOfName)) {
            return CONTINUE;
        }
        foundFiles.add(file.getFileName().toString());
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }
}
