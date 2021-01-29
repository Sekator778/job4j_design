package condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArithmeticActionsTest {
    @Test
    public void selectActionAdded() {
        String action = ArithmeticActions.selectAction(5, 10, 15);
        assertThat(action, is("added"));
    }

    @Test
    public void selectActionSubtracted() {
        String action = ArithmeticActions.selectAction(10, 5, 5);
        assertThat(action, is("subtracted"));
    }

    @Test
    public void selectActionMultiplied() {
        String action = ArithmeticActions.selectAction(3, 5, 15);
        assertThat(action, is("multiplied"));
    }

    @Test
    public void selectActionDivided() {
        String action = ArithmeticActions.selectAction(15, 5, 3);
        assertThat(action, is("divided"));
    }

    @Test
    public void selectActionNone() {
        String action = ArithmeticActions.selectAction(1, 10, 100);
        assertThat(action, is("none"));
    }
}