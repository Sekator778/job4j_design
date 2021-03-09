package array;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EvenPrintTest {

    @Test
    public void whenNonEmpty() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        EvenPrint.print(new int[]{1, 2, 3, 4});
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "4" + ln + "2" + ln
        ));
    }

    @Test
    public void whenEmpty() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        EvenPrint.print(new int[]{1, 3, 5});
        assertThat(out.toString(), is(""));
    }

}