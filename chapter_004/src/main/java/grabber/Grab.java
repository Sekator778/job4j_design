package grabber;

/**
 *Периодический запуск.
 *
 * В этом проекты мы будем использовать quartz для запуска парсера. Но напрямую мы не будем его использовать.
 *
 * Абстрагируемся через интерфейс.
 */

public interface Grab {
    void init(Parse parse, Store store);
}