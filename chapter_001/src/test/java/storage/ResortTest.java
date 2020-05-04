package storage;

import org.junit.Before;
import org.junit.Test;
import store.ControllQuality;
import store.foods.Apple;
import store.foods.Food;
import store.storage.Shop;
import store.storage.Storage;
import store.storage.Trash;
import store.storage.Warehouse;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 *
 */

public class ResortTest {
    private final LocalDate now = LocalDate.now();
    private List<Storage> storages;
    private  Storage warehouse;
    private Storage shop;
    private Storage trash;

    @Before
    public void before() {
        shop = new Storage(new Shop());
        warehouse = new Storage(new Warehouse());
        trash = new Storage(new Trash());
        storages = List.of(trash, shop, warehouse);
    }

    @Test
    public void whenResortProduct() {
        Food apple = new Apple("Redapple", now.minus(Period.ofDays(5)), now.plus(Period.ofDays(15)), 55.0, 5.0);
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(apple);
        assertThat(apple.calculateLife(), is(75.0));
        assertThat(apple.getExpireDate(), is(now.plus(Period.ofDays(15))));
        assertThat(apple.getName(), is("Redapple"));
        assertThat(apple.getPrice(), is(55.0));
        assertThat(apple.getDiscount(), is(5.0));
        assertThat(shop.getFoods(), hasItem(apple));
        assertThat(warehouse.getFoods(), not(hasItem(apple)));
        assertThat(trash.getFoods(), not(hasItem(apple)));
        controllQuality.resort();
        assertThat(shop.getFoods(), hasItem(apple));
        assertThat(warehouse.getFoods(), not(hasItem(apple)));
        assertThat(trash.getFoods(), not(hasItem(apple)));
    }
}
