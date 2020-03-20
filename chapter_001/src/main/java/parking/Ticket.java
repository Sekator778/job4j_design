package parking;

public class Ticket {
    private final int autoID;
    private final int parkingSite;

    public Ticket(int autoID, int parkingSite) {
        this.autoID = autoID;
        this.parkingSite = parkingSite;
    }

    public int getAutoID() {
        return autoID;
    }

    public int getParkingSite() {
        return parkingSite;
    }

    @Override
    public String toString() {
        return "Ticket {" + "for autoID = " + autoID + ", reserve to parkingSite = " + parkingSite + '}';
    }
}
