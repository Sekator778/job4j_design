package parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FinderTest {

    @Test
    public void findSpaceForTruckWhenPlaceOnlyCar() {
        Parking parking = new Parking(1, 0);
        Finder finder = new Finder(parking);
        Auto truck = new Truck(23);
        Auto car = new Car(232);
        assertNull(finder.findPlaceForAuto(truck));
        assertNotNull(finder.findPlaceForAuto(car));
        new Place().resetNumberPlace();
    }

    @Test
    public void findSpaceForCar() {
        Parking parking = new Parking(1, 0);
        Finder finder = new Finder(parking);
        Auto car1 = new Car(232);
        assertThat(finder.findPlaceForAuto(car1).getNumberPlace(), is(1));
        new Place().resetNumberPlace();
    }

    @Test
    public void testBusyOrNo() {
        Parking parking = new Parking(1, 0);
        Finder finder = new Finder(parking);
        Auto car1 = new Car(232);
        Auto car2 = new Car(23);
        assertThat(finder.findPlaceForAuto(car1).getNumberPlace(), is(1));
        new Place().resetNumberPlace();
    }
}