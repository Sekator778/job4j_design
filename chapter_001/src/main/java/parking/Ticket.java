package parking;

import java.util.Arrays;

/**
 * билет в нем айди авто и место для этого авто на стоянке
 */
public class Ticket {
    private final int autoID;
    private final int[] parkingPlace;

    public Ticket(int autoID, int[] parkingPlace) {
        this.autoID = autoID;
        this.parkingPlace = parkingPlace;
    }

    public int getAutoID() {
        return autoID;
    }

    public int[] getParkingPlace() {
        return parkingPlace;
    }

    @Override
    public String toString() {
        return "Ticket {" + "for autoID = " + autoID + ", reserve to parkingSite = " + Arrays.toString(parkingPlace) + '}';
    }

}
