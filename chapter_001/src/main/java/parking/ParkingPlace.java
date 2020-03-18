package parking;

public class ParkingPlace {
    private  final int size;
    private boolean busy;

    public ParkingPlace(int size) {
        this.size = size;
    }
    public void setFree() {
        busy = false;
    }
    public void setBusy() {
        busy = true;
    }

    public boolean isBusy() {
        return busy;
    }
}
