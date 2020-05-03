package parking;

import java.util.HashMap;
import java.util.Map;

/**
 * класс менеджер по работе паркинга
 * имеет карту авто билетов
 * и с помощью сервиса файндер ищет место или освобождает место на паркинге
 */
public class Service {
    private final SpaceFinder finder;
    /**
     * карта авто которые на стоянке
     */
    private final Map<Ticket, Auto> carParking = new HashMap<>();

    public Service(SpaceFinder finder) {
        this.finder = finder;
    }


    /**
     * ставим авто на паркоместо
     *
     * @param auto авто которое вехало
     * @return билет с местом и айди авто
     */
    public Ticket parkingAuto(Auto auto) {
        Ticket ticket = null;
        if (finder.checkFreePlace()) {
            Place place = finder.findPlaceForAuto(auto);
            place.takenPlace();
            ticket = new Ticket(auto.getId(), place.getNumberPlace());
            carParking.put(ticket, auto);
        }
        return ticket;
    }

    public Auto leaveParkingAuto(Ticket ticket) {
        Auto auto = null;
        for (Map.Entry<Ticket, Auto> pair : carParking.entrySet()
        ) {
            if (pair.getKey().equals(ticket)) {
                auto = pair.getValue();
                finder.clearPlace(ticket);
                break;
            }
        }
        if (auto == null) {
            throw new IllegalArgumentException("Wrong ticket");
        }
        return auto;
    }
}
