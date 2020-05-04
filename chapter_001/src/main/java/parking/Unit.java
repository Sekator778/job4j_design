package parking;

/**
 * вынем все с местом в интерфейс
 * так как стоянка будет не только место на парковке
 * а место картотеке или еще где
 * и класс паркинг сможет и с теми единицами пространства работать
 */
public interface Unit {
    int size();

    boolean isPlaceTaken();

    /**
     * занимаем место
     */
    void takenPlace();

    /**
     * освобождаем место
     */
    void freePace();

    int getNumberPlace();

}
