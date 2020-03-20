package io.config;

import config.Config;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "/home/sekator/projects/job4j_design/input.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("login"),
                is("Admin")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenEmptyStringAndWrongPair() {
        String path = "/home/sekator/projects/job4j_design/input.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("loginx"),
                is("Admin")
        );
    }
}