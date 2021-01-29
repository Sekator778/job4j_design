package condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test
    public void checkNumberHelloWorld() {
        String s = HelloWorld.checkNumber(15);
        assertThat(s, is("Hello, World!!!"));
    }

    @Test
    public void checkNumberHello() {
        String s = HelloWorld.checkNumber(9);
        assertThat(s, is("Hello"));
    }

    @Test
    public void checkNumberWorld() {
        String s = HelloWorld.checkNumber(25);
        assertThat(s, is("World"));
    }

    @Test
    public void checkNumberDefault() {
        String s = HelloWorld.checkNumber(14);
        assertThat(s, is("Operation not support"));
    }
}