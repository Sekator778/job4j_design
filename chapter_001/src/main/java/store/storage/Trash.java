package store.storage;

import store.foods.Food;

import java.util.List;

public class Trash implements StorageStrategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean moveFood = false;
        if (food.calculateLife() >= 100.0) {
            moveFood = foods.add(food);
        }
        return moveFood;
    }
}