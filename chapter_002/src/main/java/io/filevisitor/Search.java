package io.filevisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public static List<String> search(Path root, String ext) throws IOException {
        List<String> result = new ArrayList<>();

        PrintFiles printFiles = new PrintFiles(ext, result);
        Files.walkFileTree(root, printFiles);

        return result;
    }

    public static void main(String[] args) throws IOException {
        search(Paths.get("/home/sekator/projects/"), "js")
                .forEach(System.out::println);
    }
}