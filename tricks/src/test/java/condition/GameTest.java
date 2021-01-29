package condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void checkGame() {
        int rsl = Game.checkGame(0.2, 50, 9);
        assertThat(rsl, is(1));
    }

    @Test
    public void checkGameIs0() {
        int rsl = Game.checkGame(0.9, 1, 2);
        assertThat(rsl, is(0));
    }
}