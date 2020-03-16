package store;

import java.time.LocalDate;
import java.util.Date;

public class Food {
    private String name;
    private double expireDate;
    private double createDate;
    private double price;
    private double discount;

    public double getCreateDate() {
        return createDate;
    }

    public double getExpireDate() {
        return expireDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpireDate(double expireDate) {
        this.expireDate = expireDate;
    }

    public void setCreateDate(double createDate) {
        this.createDate = createDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
