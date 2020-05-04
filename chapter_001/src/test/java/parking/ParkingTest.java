package parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {
    private Parking parking;

    @Before
    public void setUp() throws Exception {
        parking = new Parking(123, 23);
    }

    @Test
    public void whenReturnSizeParking() {
        assertThat(parking.returnSizeParking(), is((123 * 1 + 23 * 4)));
        new Place().resetNumberPlace();
    }

    @Test
    public void whenReturnSizeParkingOnlyCar() {
        Parking carParking = new Parking(2);
        assertThat(carParking.returnSizeParking(), is(2));
    }
}