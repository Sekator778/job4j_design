package finder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Represents arguments for the start of the application.
 */
public class Args {
    /**
     * Name of the default output file.
     */
    private static final String DEFAULT_OUTPUT = "log.txt";
    /**
     * Command line arguments.
     */
    private String[] args;
    /**
     * Index of the current argument.
     */
    private int idx;
    /**
     * Starting directory.
     */
    private Path directory = Paths.get("");
    /**
     * Name of the file or search pattern.
     */
    private String name;
    /**
     * Type of search.
     */
    private SearchBy searchBy = SearchBy.FULL;
    /**
     * Name of the output file.
     */
    private String output = DEFAULT_OUTPUT;
    /**
     * Actions used to receive values of the arguments.
     */
    private final Map<String, Supplier<Object>> actions = Map.of(
            "-d", () -> directory = Paths.get(args[++idx]),
            "-n", () -> name = args[++idx],
            "-o", () -> output = args[++idx],
            "-m", () -> searchBy = SearchBy.MASK,
            "-f", () -> searchBy = SearchBy.FULL,
            "-r", () -> searchBy = SearchBy.REGEX
    );

    /**
     * Creates an instance of arguments.
     *
     * @param args command line arguments
     * @throws IllegalArgumentException if arguments are invalid
     */
    public Args(String[] args) {
        this.args = args;
        parse();
    }

    /**
     * Produces parsed arguments.
     */
    private void parse() {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments");
        }
        for (idx = 0; idx < args.length; idx++) {
            String arg = args[idx];
            actions.getOrDefault(arg, () -> {
                throw new IllegalArgumentException(String.format("Invalid argument: '%s'", arg));
            }).get();
        }
    }

    /**
     * @return starting directory
     */
    public Path getDirectory() {
        return directory;
    }

    /**
     * @return file name or pattern
     */
    public String getName() {
        return name;
    }

    /**
     * @return type of search
     */
    public SearchBy getSearchBy() {
        return searchBy;
    }

    /**
     * @return name of the output file
     */
    public String getOutput() {
        return output;
    }
}