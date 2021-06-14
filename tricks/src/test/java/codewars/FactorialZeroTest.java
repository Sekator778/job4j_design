package codewars;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FactorialZeroTest {
    @Test
    public void testZeros() throws Exception {
        assertThat(FactorialZero.zeros(0), is(0));
        assertThat(FactorialZero.zeros(6), is(1));
        assertThat(FactorialZero.zeros(14), is(2));
    }

}