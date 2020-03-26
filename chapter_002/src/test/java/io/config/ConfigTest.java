package io.config;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "../input.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("login"),
                is("admin")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenEmptyStringAndWrongPair() {
        String path = "../input.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("loginx"),
                is("Admin")
        );
    }
}