package ood.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {
    List<Session> find(Predicate<Session> filter);

    Ticket buy(Account account, int row, int column, Calendar date);

    void add(Session session);

    /**
     * сеанс не висит вечно
     * @param session - сеанс кино
     */
    void delete(Session session);


}