package parking;

public class Token {
    private final int autoID;
    private final int parkingSite;

    public Token(int autoID, int parkingSite) {
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
        return "Token{" + "for autoID=" + autoID + ", reserve to parkingSite=" + parkingSite + '}';
    }
}
