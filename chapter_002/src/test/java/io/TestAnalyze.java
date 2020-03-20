package io;

import config.Config;
import org.junit.Test;
import server.Analyze;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestAnalyze {

    @Test
    public void whenPairWithoutComment() {
        String path = "/home/sekator/projects/job4j_design/server.log";
        new Analyze().unavailable("/home/sekator/projects/job4j_design/server.log", "target.txt");
//        assertThat(
//                config.value("login"),
//                is("Admin")
//        );
    }
}