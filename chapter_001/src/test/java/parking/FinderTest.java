package parking;

import org.junit.Test;
import parking.auto.Auto;
import parking.auto.Car;
import parking.auto.Truck;

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
        assertThat(finder.findPlaceForAuto(car1)[0].getNumberPlace(), is(1));
        new Place().resetNumberPlace();
    }

    @Test
    public void testBusyOrNo() {
        Parking parking = new Parking(1, 0);
        Finder finder = new Finder(parking);
        Auto car1 = new Car(232);
        Auto car2 = new Car(23);
        assertThat(finder.findPlaceForAuto(car1)[0].getNumberPlace(), is(1));
        new Place().resetNumberPlace();
    }

    @Test
    public void testParkingTruckOn4PlaceCar() {
        Parking parking = new Parking(4, 0);
        Finder finder = new Finder(parking);
        Auto truck = new Truck(232);
        int i = 1;
        Unit[] numberPlaces = finder.findPlaceForAuto(truck);
        for (Unit place : numberPlaces
        ) {
            assertThat(place.getNumberPlace(), is(i++));
        }
        new Place().resetNumberPlace();
    }
}