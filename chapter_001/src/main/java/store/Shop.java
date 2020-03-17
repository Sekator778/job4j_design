package store;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final double discount = 0.25;
    public final List<Food> shopFoodList = new ArrayList<>();

    public void add(Food food) {
        shopFoodList.add(food);
    }

    public void add(Food food, double discount) {
        food.setDiscount(discount);
        shopFoodList.add(food);
    }

    @Override
    public List<Food> getFood() {
        return shopFoodList;
    }

    @Override
    public boolean validate(Food food) {
        boolean rsl = false;
        double term = food.calculateLife(food);
        if ((term > 75.0) && (term < 100)) {
            rsl = true;
            food.setDiscount(discount);
        } else if ((term > 25.0) && (term < 75.0)) {
            rsl = true;
        }
        return rsl;
    }
}
