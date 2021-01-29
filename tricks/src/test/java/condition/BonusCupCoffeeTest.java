package condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BonusCupCoffeeTest {
    @Test
    public void countCup() {
        int rsl = BonusCupCoffee.countCup(7, 6);
        assertThat(rsl, is(8));
    }

    @Test
    public void countCup1() {
        int rsl = BonusCupCoffee.countCup(213, 6);
        assertThat(rsl, is(248));
    }
}