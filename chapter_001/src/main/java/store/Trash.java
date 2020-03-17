package store;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    public final List<Food> trashFoodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        trashFoodList.add(food);
    }

    @Override
    public boolean validate(Food food) {
        boolean rsl = false;
        if (food.calculateLife(food) < 0.0) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getFood() {
        return trashFoodList;
    }
}