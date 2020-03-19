package store.storage;

import store.foods.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * поле стратегия может быть любой кто реализует эту стратегию
 */
public class Storage {

    private StorageStrategy strategy;
    private List<Food> foods;

    /**
     * вот тут когда создаем хранилище
     * имеем пустое поле для когото %)
     * и чистенький лист для того когото свой личный %)
     */
    public Storage(StorageStrategy strategy) {
        this.strategy = strategy;
        this.foods = new ArrayList<>();
    }

    public boolean add(Food food) {
        return this.strategy.add(food, this.foods);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public boolean checkStore(Food food) {
        return foods.contains(food);
    }
}
