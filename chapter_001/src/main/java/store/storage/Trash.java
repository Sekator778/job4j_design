package store.storage;

import store.foods.Food;

import java.util.List;

public class Trash implements StorageStrategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean moveFood = false;
        if (check(food)) {
            moveFood = foods.add(food);
//            System.out.println("Trash add");
        }
        return moveFood;
    }

    @Override
    public boolean check(Food food) {
        boolean rsl = false;
        if (food.calculateLife() >= 100.0) {
            rsl = true;
        }
        return rsl;
    }
}