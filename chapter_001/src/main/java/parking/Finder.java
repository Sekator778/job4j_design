package parking;

import java.util.List;

/**
 * смотрим описание методов в интерфейсе
 *
 */
public class Finder implements SpaceFinder {
    private final Parking parking;
    private List<Place> places;

    public Finder(Parking parking) {
        this.parking = parking;
    }

    @Override
    public Place findPlaceForAuto(Auto auto) {
        places = parking.getPlaceList();
        if (places == null || places.size() == 0) {
            throw new IllegalStateException("Parking no INIT");
        }
        int carSize = auto.size();
        Place result = null;
        for (Place place : places
        ) {
            if (!place.isPlaceTaken() && place.size() == carSize) {
                result = place;
                break;
            }
        }
        return result;
    }

    @Override
    public Place findPlaceForTicket(Ticket ticket) {
        Place place = null;
        for (Place p : places
        ) {
            if (p.getNumberPlace() == ticket.getParkingPlace()) {
                place = p;
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
        for (Place p : places
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
