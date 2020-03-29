package io.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Searches files in a specified directory.
 */
public class FindService {
    private final Path startDir;
    private final int maxDepth;

    public FindService(Path startDir, int maxDepth) {
        this.startDir = startDir;
        this.maxDepth = maxDepth;
    }

    /**
     * Finds files in a file tree using the specified search type.
     * @param name name of the file or pattern for other types of search
     * @param searchBy type of search
     * @return list of found files
     */
    public List<Path> find(String name, SearchBy searchBy) throws IOException {

        BiPredicate<Path, BasicFileAttributes> matcher;

        if (searchBy == SearchBy.FULL) {
            matcher = (path, a) -> path.getFileName().toString().equals(name);
        } else {
            var pathMatcher = startDir.getFileSystem().getPathMatcher(searchBy.getSyntax() + ":" + name);
            matcher = (path, a) -> pathMatcher.matches(path.getFileName());
        }
        List<Path> result;
        try (Stream<Path> pathStream = Files.find(startDir, maxDepth, matcher)) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;
    }
}