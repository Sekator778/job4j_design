package cas;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * позже сюда надо добавить распараллеливание
 * а сейчас ознакомимся с атомарностью а именно CAS
 */
public class CasCounterTest {

    @Test
    public void increment() {
        SimulatedCAS value = new SimulatedCAS();
        value.setValue(0);
        CasCounter casCounter = new CasCounter(value);
        assertThat(casCounter.increment(), is(1));
    }
}