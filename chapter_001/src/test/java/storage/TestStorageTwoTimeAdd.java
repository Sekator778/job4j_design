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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestStorageTwoTimeAdd {
    private final LocalDate now = LocalDate.now();
    private List<Storage> storages;

    @Before
    public void before() {
        Storage shop = new Storage(new Shop());
        Storage warehouse = new Storage(new Warehouse());
        Storage trash = new Storage(new Trash());
        storages = List.of(trash, shop, warehouse);
    }
    @Test
    public void whenFoodAddToWarehouse() {
        ControllQuality controlQuality = new ControllQuality(storages);
        Food apple = new Apple(
                "Simple", now.minus(Period.ofDays(5)), now.plus(Period.ofDays(50)), 100, 10);
        boolean firstTime = controlQuality.addToStorage(apple);
        assertThat(firstTime, is(true));
    }
}