package array;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NonSquareArrayTest {
    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        NonSquareArray.main(null);
        String ln = System.lineSeparator();
        String expected = "1" + ln + "1" + ln + "2" + ln + "2" + ln + "3" + ln + "3" + ln + "4" + ln + "5" + ln + "6" + ln;
        assertThat(out.toString(), is(expected));
    }
}