package store.storage;

import store.foods.Food;

import java.util.List;

/**
 * Общий интерфейс всех стратегий.
 * касаемо хранилищ
 * кто его реализует тот полиморфно работает там где
 * есть поле  private StorageStrategy strategy
 * получаеться что шоп должен называться шопстратегия гм.....
 */

public interface StorageStrategy {
    /**
     * вот метод который в последствии добавляет в какой то лист
     * но уже под действием стратегии еду
     * @param food - some food
     * @param foods - some list
     * @return - add or no add
     */
    boolean add(Food food, List<Food> foods);

    /**
     * чек по условиям
     * @param food еда
     * @return подходит да
     */
    boolean check(Food food);
}
