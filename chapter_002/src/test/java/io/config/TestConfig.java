package io.config;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestConfig {

    @Test
    public void whenPairToKey() {
        String path = "/home/sekator/projects/job4j_design/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenPairNoFindKey() {
        String path = "/home/sekator/projects/job4j_design/result.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }
}
