package loop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MultipliersTest {

    @Test
    public void when1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Multipliers.out(1);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "1" + ln
        ));
    }

    @Test
    public void when2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Multipliers.out(2);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "1" + ln +
                        "2" + ln
        ));
    }

    @Test
    public void when6() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Multipliers.out(6);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "1" + ln +
                        "2" + ln +
                        "3" + ln +
                        "6" + ln
        ));
    }

}