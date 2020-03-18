package store.foods;

import java.time.LocalDate;
import java.time.Period;

/**
 * общий фрукт)
 * сюда вынесли все и тот самый метод который дает нам число
 * по которому работает наша стратегия
 */
public abstract class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expireDate;
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
        this.createDate = createDate;
        this.expireDate = expireDate;
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
     * главный метод от которого зависист судьба все го проекта
     * @return - округленный процент скоко осталось годности
     */
    public double calculateLife() {
        int storageLife = Period.between(getCreateDate(), getExpireDate()).getDays();
        int remainingLife = Period.between(LocalDate.now(), getExpireDate()).getDays();
        return Math.round((1.0 * (storageLife - remainingLife) / storageLife) * 100.0);
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\'' + ", createDate=" + createDate + ", expireDate=" + expireDate + ", price=" + price + ", discount=" + discount + '}';
    }
}
