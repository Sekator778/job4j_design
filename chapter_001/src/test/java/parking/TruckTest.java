package parking;

import org.junit.Before;
import org.junit.Test;
import parking.auto.Auto;
import parking.auto.Truck;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TruckTest {
    private Auto track;

    @Before
    public void init() {
        track = new Truck(123);
    }

    @Test
    public void getId() {
        assertThat(track.getId(), is(123));
    }

    @Test
    public void size() {
        assertThat(track.size(), is(4));
    }
}