package condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AttackRookTest {
    @Test
    public void checkTrue() {
        boolean check = AttackRook.check("A8", "E8");
        assertThat(check, is(true));
    }

    @Test
    public void checkTrue1() {
        boolean check = AttackRook.check("H4", "H3");
        assertThat(check, is(true));
    }

    @Test
    public void checkFalse() {
        boolean check = AttackRook.check("A1", "B2");
        assertThat(check, is(false));
    }

    @Test
    public void checkFalse1() {
        boolean check = AttackRook.check("F5", "C8");
        assertThat(check, is(false));
    }
}