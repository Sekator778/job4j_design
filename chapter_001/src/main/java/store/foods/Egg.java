package store.foods;

import java.time.LocalDate;

public class Egg extends Food {
    public Egg(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
