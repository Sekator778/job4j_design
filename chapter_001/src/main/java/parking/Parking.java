package parking;

import java.util.ArrayList;
import java.util.List;

/**
 * парковка то есть место разделенное на паркоместа Place
 */
public class Parking {
    private final List<Place> placeList;

    /**
     * важный момент при создании паркинга она инит делает парковке
     * с размером указанным при начале
     * @param numCarPlace сколько легковых
     * @param numTrackPlace сколько грузовиков
     */
    public Parking(int numCarPlace, int numTrackPlace) {
        this.placeList = initParking(numCarPlace, numTrackPlace);
    }

    /**
     * метод инит !!!!!!!!!!!!!!!!!!!
     * тут надо зависимость от Place а то вроде и есть но на диаграмме нет
     *
     * @return парковку разбитую на количество указанных мест фор кар и траков
     */
    private List<Place> initParking(int numCarPlace, int numTrackPlace) {
        List<Place> places = new ArrayList<>();

        for (int i = 0; i < numCarPlace; i++) {
            int defaultCarSize = 1;
            places.add(new Place(defaultCarSize));
        }
        for (int i = 0; i < numTrackPlace; i++) {
            int defaultTrackSize = 4;
            places.add(new Place(defaultTrackSize));
        }
        return places;
    }

    /**
     * считаем все размеры паркомест на стоянке
     *
     * @return размер парковки
     */
    public int returnSizeParking() {
        int size = 0;
        for (Place p : placeList
        ) {
            size += p.size();
        }
        return size;
    }

    /**
     * очищаем всю парковку
     */
    public void free() {
        for (Place p : placeList
        ) {
            p.freePace();
        }
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    /**
     * когда авто покидает стоянку надо место освободить
     * @param ticket тикет с местом которое освободить
     */
    public void clearPlace(Ticket ticket) {
        for (Place place : placeList
             ) {
            if (place.getNumberPlace() == ticket.getParkingPlace()) {
                place.freePace();
                break;
            }
        }
    }
}
