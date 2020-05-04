package parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicketTest {
    private Ticket ticket;

    @Before
    public void init() {
        int[] ticketsNumber = new int[1];
        ticketsNumber[0] = 1;
        ticket = new Ticket(23, ticketsNumber);
    }

    @Test
    public void getAutoID() {
        assertThat(ticket.getAutoID(), is(23));
    }

    @Test
    public void getParkingSite() {
        int i = ticket.getParkingPlace()[0];
        assertThat(i, is(1));
    }

    @Test
    public void getMultiParkingSite() {
        int[] numberPlaces = new int[]{1, 2, 3, 4};
        Ticket multiTicket = new Ticket(12, numberPlaces);
        assertArrayEquals(multiTicket.getParkingPlace(), numberPlaces);
    }
}