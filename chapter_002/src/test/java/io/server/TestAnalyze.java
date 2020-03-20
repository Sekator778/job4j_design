package io.server;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestAnalyze {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() throws IOException {
        File source = folder.newFile("source.txt");
        File expected = folder.newFile("expected.txt");
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.write("200 10:56:01 200 10:57:01 400 10:58:01 200 10:59:01 500 11:01:02 200 11:02:02");
        }
        new Analyze().unavailable(source.getAbsolutePath(), expected.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader("target.txt"))) {
            fileReader.lines().forEach(s -> builder.append(s).append(" "));
        }
        String rsl = builder.toString().trim();
        assertThat(
                rsl,
                is("10:58:01 10:59:01 11:01:02 11:02:02")
        );
    }
}