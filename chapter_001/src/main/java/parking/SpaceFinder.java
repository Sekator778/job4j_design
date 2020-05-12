package parking;

import parking.auto.Auto;

/**
 * 2й интерфейс ищет место для абстрактного авто
 * то есть с помощью реализации мы можем подставлять
 * разные типы авто
 * пару вспомогательных методов
 *
 */
public interface SpaceFinder {

    /**
     * метод главный ищет место для авто
     *
     * @param auto - любое авто
     */
    Unit[] findPlaceForAuto(Auto auto);

    /**
     * ищем место по билету
     * @param ticket билет где стоит авто
     * @return место где стоит авто
     */
    Unit[] findPlaceForTicket(Ticket ticket);

    boolean checkFreePlace();

    void clearPlace(Ticket ticket);



}
