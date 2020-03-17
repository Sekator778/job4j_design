package store;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> warehouseFoodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (!warehouseFoodList.contains(food)) {
            warehouseFoodList.add(food);
        }
    }

    @Override
    public List<Food> getFood() {
        return warehouseFoodList;
    }

    @Override
    public boolean validate(Food food) {
        boolean rsl = false;
        if (food.calculateLife(food) < 25.0) {
           rsl = true;
        }
        return rsl;
    }
}
