package io;

import config.Config;
import org.junit.Test;
import server.Analyze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestAnalyze {

    @Test
    public void whenPairWithoutComment() throws IOException {
        String path = "/home/sekator/projects/job4j_design/server.log";
        new Analyze().unavailable("/home/sekator/projects/job4j_design/server.log", "target.txt");
        BufferedReader fileReader = new BufferedReader(new FileReader("target.txt"));
        String one = fileReader.readLine();
        assertThat(
                one,
                is("10:57:01")
        );
    }
}