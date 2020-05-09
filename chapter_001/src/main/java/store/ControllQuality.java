package store;

import store.foods.Food;
import store.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    /**
     * метод верхний назвал бы я его
     * он всем подряд Storage из листа storages
     * кидает фуд и ждет что он вернет тру если фуд забрал
     * фолс и дальше крутим
     * гм надо бно чекать если никто не примет нашу фуд
     *
     * @param food - some food
     * @return - true if add food to any storage
     */
    public boolean addToStorage(Food food) {
        boolean rsl = false;
        for (Storage storage : storages
        ) {
            rsl = storage.add(food);
            if (rsl) {
                    break;
            }
        }
        return rsl;
    }

    /**
     * извлекать все продукты и перераспределять их заново
     * 1. все сториджи скидывают все свои продукты в один общий лист redistribution
     * 2. всем продуктам дисконт в 0.0
     * 3. все продукты добавить обратно в хранилища
     */
    public void resort() {
        List<Food> redistribution = new ArrayList<>();
        for (Storage store : storages) {
            redistribution.addAll(store.takeAll());
        }
        redistribution.forEach(food -> food.setDiscount(0.0));
        for (Food food : redistribution
        ) {
            addToStorage(food);
        }
    }
}
