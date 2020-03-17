package store;

import java.time.LocalDate;

public class Tomato extends Food {
    public Tomato(String name, LocalDate expireDate, LocalDate createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
