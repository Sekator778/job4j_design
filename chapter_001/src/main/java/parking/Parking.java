package parking;

import java.util.List;
import java.util.Map;

public class Parking {
    private  final int size;
    private boolean busy;
    private List<Place> placeList;

    public Parking(int size) {
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
