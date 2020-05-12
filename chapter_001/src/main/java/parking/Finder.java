package parking;

import parking.auto.Auto;

import java.util.ArrayList;
import java.util.List;

/**
 * смотрим описание методов в интерфейсе
 */
public class Finder implements SpaceFinder {
    private final Parking parking;
    private List<Unit> places;

    public Finder(Parking parking) {
        this.parking = parking;
    }

    /**
     * ищем место на парковке
     * 1. если парколист пустой или размер 0 то его нет
     * 2. к каждому месту сравниваем размер авто если подходит забираем
     * 3. если не нашли то смотри м есть ли вообще размер который вмещает размер авто
     *
     * @param auto - любое авто
     * @return массив мест
     */
    @Override
    public Unit[] findPlaceForAuto(Auto auto) {
        places = parking.getPlaceList();
        if (places == null || places.size() == 0) {
            throw new IllegalStateException("Parking no INIT");
        }
        int carSize = auto.size();
        Unit[] result = new Unit[carSize];
        for (Unit place : places
        ) {
            if (!place.isPlaceTaken() && place.size() == carSize) {
                result[0] = place;
                break;
            }
        }
        if (result[0] == null && (parking.returnSizeParking() >= carSize)) {
            result = findForTruck(auto, places);
        }
        if (result[0] == null) {
            result = null;
        }
        return result;
    }

    /**
     * сюда приходим если места на стоянке есть
     *
     * @param auto трак
     * @return массив мест
     */
    private Unit[] findForTruck(Auto auto, List<Unit> places) {
        Unit temp = null;
        List<Unit> placesForTruck = new ArrayList<>();
        int carSize = auto.size();
        int i1 = 0;
        for (int i = 0; i < places.size(); i++) {
            if (!places.get(i).isPlaceTaken()) {
                temp = places.get(i);
                i1 = i;
                placesForTruck.add(temp);
                break;
            }
        }
        for (int i = i1 + 1; i < places.size(); i++) {
            if ((places.get(i).getNumberPlace() - 1) == temp.getNumberPlace()) {
                placesForTruck.add(places.get(i));
                if (placesForTruck.size() == carSize) {
                    break;
                }
                temp = places.get(i);
           }
        }
        Unit[] result = new Unit[placesForTruck.size()];
        int j = 0;
        for (Unit place : placesForTruck
        ) {
            result[j++] = place;
        }
        return result;
    }

    /**
     * по билету ищем места
     * @param ticket билет где стоит авто
     * @return масив мест
     */
    @Override
    public Unit[] findPlaceForTicket(Ticket ticket) {
        Unit[] place = null;
        int j = 0;
        for (Unit p : places
        ) {
            for (Integer numberPlace : ticket.getParkingPlace()
            ) {
                if ((p.getNumberPlace() == numberPlace)) {
                    place[j++] = p;
                }
            }
        }
        return place;
    }

    private int parkingSize() {
        return parking.returnSizeParking();
    }

    @Override
    public boolean checkFreePlace() {
        places = parking.getPlaceList();
        int sizeBusyParking = 0;
        int parkingSize = parkingSize();
        for (Unit p : places
        ) {
            if (p.isPlaceTaken()) {
                sizeBusyParking += p.size();
            }
        }
        return (parkingSize > sizeBusyParking);
    }

    @Override
    public void clearPlace(Ticket ticket) {
        parking.clearPlace(ticket);
    }
}
