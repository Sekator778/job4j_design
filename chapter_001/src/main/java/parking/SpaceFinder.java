package parking;

import java.util.List;

/**
 * 2й интерфейс ищет место для абстрактоного авто
 * тоесть с помощью реализации мы можем подставлять
 * разные типы авто
 *
 */
public interface SpaceFinder {
    /**
     * делаем парковку
     * @param places лист мест
     */
    void setPlace(List<Place> places);

    /**
     * метод главный ищет место для авто
     * @param auto - любое авто
     */
    Parking findSpaceForAuto(Auto auto);

}
