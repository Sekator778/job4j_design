package store;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    public static final List<Food> SHOP_FOOD_LIST = new ArrayList<>();

    public void add(Food food) {
        SHOP_FOOD_LIST.add(food);
    }
    public void add(Food food, double discount) {
        food.setDiscount(discount);
        SHOP_FOOD_LIST.add(food);
    }
}
