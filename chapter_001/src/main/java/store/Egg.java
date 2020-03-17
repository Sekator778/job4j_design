package store;

import java.time.LocalDate;

public class Egg extends Food {
    public Egg(String name, LocalDate expireDate, LocalDate createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
