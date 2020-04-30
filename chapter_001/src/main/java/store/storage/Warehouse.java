package store.storage;

import store.foods.Food;

import java.util.List;

public class Warehouse implements StorageStrategy {

    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean moveFood = false;
        if (check(food)) {
            moveFood = foods.add(food);
//            System.out.println("warehouse add");
        }
        return moveFood;
    }

    @Override
    public boolean check(Food food) {
        boolean rsl = false;
        if (food.calculateLife() < 25.0) {
            rsl = true;
        }
        return rsl;
    }
}
