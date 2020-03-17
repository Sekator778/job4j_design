package store;

import java.time.LocalDate;

public class Apple extends Food {
    public Apple(String name, LocalDate expireDate, LocalDate createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
