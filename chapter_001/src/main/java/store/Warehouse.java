package store;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private static final List<Food> WAREHOUSE_FOOD_LIST = new ArrayList<>();

    @Override
    public void add(Food food) {
        WAREHOUSE_FOOD_LIST.add(food);
    }
}
