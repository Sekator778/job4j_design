package store.foods;

import java.time.LocalDate;

public class Apple extends Food {
    public Apple(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
