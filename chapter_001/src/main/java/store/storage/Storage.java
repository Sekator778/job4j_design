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

    /**
     * !!! просто List<Food> taken = foods;  будет ссылка
     * надо создавать через new ArrayList<>(); !!!!!!
     * дай все продукты
     * и наш список продуктов очисть
     * @return вернет лист продуктов
     */
    public List<Food> takeAll() {
        List<Food> taken = new ArrayList<>(foods);
        foods.clear();
        return taken;
     }

    public boolean isEmpty() {
        return foods.isEmpty();
    }
}
