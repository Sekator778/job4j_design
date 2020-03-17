package store;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate expireDate, LocalDate createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
