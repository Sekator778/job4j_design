package io.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Represents arguments for the start of the application.
 */
public class Args {
    private String[] args;
    private int index;
    private Path root = Paths.get("");
    private String name;
    private SearchBy searchBy = SearchBy.FULL;
    private String output = "logout.txt";
    private final Map<String, Supplier<Object>> actions = Map.of(
            "-d", () -> root = Paths.get(args[++index]),
            "-n", () -> name = args[++index],
            "-o", () -> output = args[++index],
            "-m", () -> searchBy = SearchBy.MASK,
            "-f", () -> searchBy = SearchBy.FULL,
            "-r", () -> searchBy = SearchBy.REGEX
    );

    public Args(String[] args) {
        this.args = args;
        parsingArgs();
    }

    private void parsingArgs() {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments");
        }
        for (index = 0; index < args.length; index++) {
            String arg = args[index];
            actions.getOrDefault(arg, () -> {
                throw new IllegalArgumentException(String.format("Error argument: '%s'", arg));
            }).get();
        }
    }

    public Path getRoot() {
        return root;
    }

    public String getName() {
        return name;
    }

    public SearchBy getSearchBy() {
        return searchBy;
    }

    public String getOutput() {
        return output;
    }
}