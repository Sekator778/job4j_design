package finder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class that starts the application using command line arguments.
 */
public class Find {
    /**
     * @param args used arguments: [-d directory] -n name [-m | -f | -r] [-o output]
     *             <p>
     *             -d directory    directory where the search starts
     *             -n name         name of the file or pattern for other types of search
     *             -m              search by mask
     *             -f              search by full name
     *             -r              search by regular expression
     *             -o output       name of the result file
     *             <p>
     *             default starting directory is the current directory
     *             default search is by full name
     *             default result file is 'log.txt'
     */
    public static void main(String[] args) {
        Args arguments;
        try {
            arguments = new Args(args);
        } catch (IllegalArgumentException e) {
            displayUsage();
            return;
        }
        try {
            List<String> result = findFiles(arguments.getDirectory(), arguments.getName(), arguments.getSearchBy());
            writeResult(result, arguments.getOutput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds files in the specified directory.
     *
     * @param dir  starting directory
     * @param name name of the file or pattern for other types of search
     * @param type type of search
     * @return list of found files
     * @throws IOException if an I/O error occurs
     */
    private static List<String> findFiles(Path dir, String name, SearchBy type) throws IOException {
        Finder finder = new Finder(dir, Integer.MAX_VALUE);
        List<Path> paths = finder.find(name, type);
        List<String> lines = new ArrayList<>();
        paths.forEach(p -> lines.add(p.toString()));
        return lines;
    }

    /**
     * Writes result to the specified file.
     *
     * @param lines  list of lines
     * @param output path to the output file
     * @throws IOException if an I/O error occurs
     */
    private static void writeResult(List<String> lines, String output) throws IOException {
        ListWriter writer = new ListWriter(Paths.get(output));
        writer.write(lines);
    }

    /**
     * Prints usage instructions to the console.
     */
    private static void displayUsage() {
        final String usage = String.join(System.lineSeparator(),
                "Usage: java -jar find.jar [-d directory] -n name [-m | -f | -r] [-o output]",
                "",
                "-d directory    directory where the search starts",
                "-n name         name of the file or pattern for other types of search",
                "-m              search by mask",
                "-f              search by full name",
                "-r              search by regular expression",
                "-o output       name of the result file",
                "",
                "default starting directory is the current directory",
                "default search is by full name",
                "default result file is 'log.txt'");
        System.out.println(usage);
    }
}