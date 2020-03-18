package store.foods;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
