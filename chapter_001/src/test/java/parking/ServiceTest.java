package parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ServiceTest {

    @Test
    public void parkingAuto() {
        Parking parking2 = new Parking(1, 0);
        Finder finder = new Finder(parking2);
        Service service = new Service(finder);
        Auto car = new Car(10);
        Ticket ticket = service.parkingAuto(car);
        assertThat(ticket.getParkingPlace()[0], is(1));
        assertThat(ticket.getAutoID(), is(10));
        parking2.free();

    }

    @Test
    public void whenNoPlaceForParkingSecondAuto() {
        Parking parking = new Parking(1, 0);
        Finder finder = new Finder(parking);
        Service service = new Service(finder);
        Auto car1 = new Car(10);
        Auto car2 = new Car(12);
        Ticket ticket = service.parkingAuto(car1);
        assertThat(ticket.getParkingPlace()[0], is(1));
        assertThat(ticket.getAutoID(), is(10));
        assertNull(service.parkingAuto(car2));
        parking.free();
    }

    @Test
    public void whenCarLeavesTheParking() {
        Parking parkingA = new Parking(2, 0);
        SpaceFinder finderA = new Finder(parkingA);
        Service serviceA = new Service(finderA);
        Auto car1 = new Car(10);
        Auto car2 = new Car(12);
        Ticket ticket1 = serviceA.parkingAuto(car1);
        Ticket ticket2 = serviceA.parkingAuto(car2);
        Auto auto = serviceA.leaveParkingAuto(ticket1);
        Auto auto2 = serviceA.leaveParkingAuto(ticket2);

        assertThat(auto.getId(), is(10));
        assertThat(auto2.getId(), is(12));
        parkingA.free();
    }

    @Test
    public void when2CarPutOnTheParkingAfterOneLeaveAndOneTruckParking() {
        Parking parkingA = new Parking(5, 0);
        SpaceFinder finderA = new Finder(parkingA);
        Service serviceA = new Service(finderA);
        Auto car1 = new Car(10);
        Auto car2 = new Car(12);
        Auto truck = new Truck(23);
        Ticket ticket1 = serviceA.parkingAuto(car1);
        Ticket ticket2 = serviceA.parkingAuto(car2);

        assertThat(ticket1.getParkingPlace()[0], is(1));
        assertThat(ticket2.getParkingPlace()[0], is(2));
        assertNull(serviceA.parkingAuto(truck));

        Auto auto2 = serviceA.leaveParkingAuto(ticket2);
        assertThat(auto2.getId(), is(12));

        assertThat(serviceA.parkingAuto(truck).toString(), is("Ticket {for autoID = 23, reserve to parkingSite = [2, 3, 4, 5]}"));
        Auto car3 = new Car(54);
        assertNull(serviceA.parkingAuto(car3));

        Auto auto = serviceA.leaveParkingAuto(ticket1);
        assertThat(auto.getId(), is(10));

        assertThat(serviceA.parkingAuto(car3).getParkingPlace()[0], is(1));
        parkingA.free();
    }
}