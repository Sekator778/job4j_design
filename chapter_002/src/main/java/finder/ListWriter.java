package finder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Writes a list of strings to a file.
 */
public class ListWriter {
    /**
     * The path to the file.
     */
    private final Path file;

    /**
     * Creates list writer for the specified file.
     *
     * @param file path to the file
     */
    public ListWriter(Path file) {
        this.file = file;
    }

    /**
     * Writes the supplied lines.
     *
     * @param lines list of lines to write
     * @throws IOException if an I/O error occurs
     */
    public void write(List<String> lines) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}