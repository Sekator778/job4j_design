package parking;

public class Track implements Auto {
    private final int id;
    private static final int SIZE = 8;

    public Track(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int size() {
        return SIZE;
    }
    @Override
    public String toString() {
        return "Car{" + "id = " + id + ", have a size = " + SIZE + '}';
    }
}
