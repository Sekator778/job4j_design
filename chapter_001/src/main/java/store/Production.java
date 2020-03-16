package store;


import static store.Shop.SHOP_FOOD_LIST;

public class Production {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setName("apple1");
        apple.setCreateDate(10.0);
        apple.setExpireDate(20.0);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.handler(apple, 10);
        System.out.println(SHOP_FOOD_LIST.get(0).getCreateDate());
    }
}
