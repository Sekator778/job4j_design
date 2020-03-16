package store;

public class ControlQuality {

    public void handler(Food food, double discount) {
        double now = 5;
        double term = food.getExpireDate() - food.getCreateDate();
        double expirationDatePercent = (food.getExpireDate() - now) / term * 100;
        if (expirationDatePercent < 25) {
            new Warehouse().add(food);
        } else if (expirationDatePercent > 75) {
            food.setDiscount(discount);
            new Shop().add(food, discount);
        } else if (expirationDatePercent < 0) {
            new Trash().add(food);
        } else {
            new Shop().add(food);
        }
    }
}
