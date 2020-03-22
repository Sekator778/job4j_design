package io.config;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestConfig {

    @Test
    public void whenPairToKey() {
        String path = "../app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenPairNoFindKey() {
        String path = "../result.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }
}
