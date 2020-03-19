package store;

import store.foods.Food;
import store.storage.Storage;

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
            if (storage.checkStore(food)) {
                continue;
            }
            if (storage.add(food)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
