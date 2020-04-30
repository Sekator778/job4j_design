package store.storage;

import store.foods.Food;

import java.util.List;

public class Shop implements StorageStrategy {
    /**
     * хочу отметить что метод адд в листе возвращает булен
     *
     * @param food - some food
     * @param foods - some list
     * @return - result true or false
     */
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean moveFood = false;
       if (check(food)) {
           moveFood = foods.add(food);
           System.out.println("Shop add");

       }
        return moveFood;
    }

    @Override
    public boolean check(Food food) {
        boolean rsl = false;
        if (food.calculateLife() >= 25.0 && food.calculateLife() <= 75.0) {
            rsl = true;
        } else if (food.calculateLife() > 75.0 && food.calculateLife() < 100.0) {
//            System.out.println("discount");
            food.setDiscount(5);
            rsl = true;
        }
        return rsl;
    }
}
