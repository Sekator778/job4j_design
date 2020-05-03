package parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicketTest {
    private Ticket ticket;
    @Before
    public void init() {
        ticket = new Ticket(23, 1);
    }

    @Test
    public void getAutoID() {
        assertThat(ticket.getAutoID(), is(23));
    }

    @Test
    public void getParkingSite() {
        assertThat(ticket.getParkingPlace(), is(1));
    }
}