package store;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    public static final List<Food> TRASH_FOOD_LIST = new ArrayList<>();

    @Override
    public void add(Food food) {
        TRASH_FOOD_LIST.add(food);
    }
}