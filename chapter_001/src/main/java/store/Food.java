package store;

import java.time.LocalDate;
import java.time.Period;

public class Food {
    private String name;
    private LocalDate expireDate;
    private LocalDate createDate;
    private double price;
    private double discount;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * peklo !!!
     * @param food - food any
     * @return - percent life food
     */
    public double calculateLife(Food food) {
        int storageLife = Period.between(food.getCreateDate(), food.getExpireDate()).getDays();
        int expirationDate = Period.between(LocalDate.now(), food.getExpireDate()).getDays();
        return (1.0 * (storageLife - expirationDate) / storageLife) * 100.0;
    }
}
