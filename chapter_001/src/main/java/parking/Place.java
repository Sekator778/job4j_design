package parking;

/**
 * единица парковки 1но место
 *
 */
public class Place {
    private static final int DEFAULT_CAR_SIZE = 1;
    private final int size;
    private boolean placeTaken;
    private static int grow;
    private final int numberPlace;

    public Place() {
        grow++;
        this.numberPlace = grow;
        this.size = DEFAULT_CAR_SIZE;
    }

    public Place(int size) {
        grow++;
        this.numberPlace = grow;
        this.size = size;
    }

    /**
     * размер 1го места в единицах паркоместа
     *
     * @return размер парковки
     */
    public int size() {
        return size;
    }

    /**
     * @return занято ли место
     */
    public boolean isPlaceTaken() {
        return placeTaken;
    }

    /**
     * занимаем место
     */
    public void takenPlace() {
        this.placeTaken = true;
    }

    /**
     * освобождаем место
     */
    public void freePace() {
        this.placeTaken = false;
        grow = 0;
    }

    /**
     * @return номер паркоместа
     */
    public int getNumberPlace() {
        return numberPlace;
    }

    /**
     * этот метод должен только минусовать номер места
     * для учета количества мест на парковке
     * а place.finalize() так просто сюда запихнули
     * @param place место
     */
    public void deletePlace(Place place) {
        try {
            place.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        --grow;
    }

    /**
     * обнуление количества мест
     */
    public void resetNumberPlace() {
        grow = 0;
    }

    @Override
    public String toString() {
        return "Place{" + "size=" + size + ", placeTaken=" + placeTaken + ", numberPlace=" + numberPlace + '}';
    }
}
