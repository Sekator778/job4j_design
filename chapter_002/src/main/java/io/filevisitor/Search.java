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

    public static void main(String[] arguments) throws IOException {
        if (arguments.length == 0) {
            throw new IllegalArgumentException(
                    "Root folder is null. Add Program argument's where [0] = root; [1] = search string ");
        }
        search(Paths.get(arguments[0]), arguments[1])
                .forEach(System.out::println);
    }
}