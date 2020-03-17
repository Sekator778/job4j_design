package store;

import java.time.LocalDate;

public class Water extends Food {
    public Water(String name, LocalDate expireDate, LocalDate createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
