package parking;

import org.junit.Before;
import org.junit.Test;
import parking.auto.Car;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    private Car car;
    @Before
    public void init() {
        car = new Car(123);
    }

    @Test
    public void getId() {
        assertThat(car.getId(), is(123));
    }

    @Test
    public void size() {
        assertThat(car.size(), is(1));
    }
}