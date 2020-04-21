package ood.tdd.cinema;

import ood.tdd.cinema.classes.AccountCinema;
import ood.tdd.cinema.classes.Cinema3D;
import ood.tdd.cinema.classes.Session3D;
import ood.tdd.cinema.classes.Ticket3D;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
@Ignore
public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    /**
     * купили билет = заняли место
     * нужно реализовать лист билетов с местами и упорядочить
     * их там с возможностью занять парами или синглами
     * до продажи и после
     */
    @Test
    public void addTicket() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Ticket ticket = new Ticket3D();
        ticket.add();
    }

    /**
     * передумал или форс - мажор
     * билет нужно вернуть
     * с листа билетов извлечь
     * деньги вернуть
     */
    @Test
    public void returnTicket() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Ticket ticket = new Ticket3D();
        ticket.remove();
    }

    /**
     * осталось пару билетов или скоро сеанс
     * нужно включить акцию продать все или
     * не заработает кинотеатр
     * выставляем билеты с новой ценой или куча акций ...
     */
    @Test
    public void checkPromotion() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Ticket ticket = new Ticket3D();
        ticket.promotions();
    }





}