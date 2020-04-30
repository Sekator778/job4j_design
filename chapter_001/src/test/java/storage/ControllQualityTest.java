package storage;


import org.junit.Before;
import org.junit.Test;
import store.ControllQuality;
import store.foods.Bread;
import store.foods.Egg;
import store.storage.Shop;
import store.storage.Storage;
import store.storage.Trash;
import store.storage.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ControllQualityTest {

    private final LocalDate now = LocalDate.now();
    private List<Storage> storages;
    private  Storage warehouse;
    private Storage shop;
    private Storage trash;

    private final Bread breadExpaireRate5 = new Bread("Bread", now.plusDays(95), now.minusDays(5), 23.45, 0);
    private final Egg egg = new Egg("Egg", now.minusDays(100), now.plusDays(0),  23.45, 0);
    private final Bread breadExpaireRate100 = new Bread("Bread", now.plusDays(0), now.minusDays(100), 23.45, 0);

    @Before
    public void before() {
        shop = new Storage(new Shop());
        warehouse = new Storage(new Warehouse());
        trash = new Storage(new Trash());
        storages = List.of(trash, shop, warehouse);
    }

    @Test
    public void whenExpaireRate5AddToShop() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(breadExpaireRate5);

        assertThat(breadExpaireRate5.getDiscount(), is(0.0));

        assertThat(shop.getFoods(), hasItem(breadExpaireRate5));
        assertThat(warehouse.getFoods(), not(hasItem(breadExpaireRate5)));
    }

    @Test
    public void whenProductLife100AndMoveTrash2() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(egg);

        assertThat(egg.getDiscount(), is(0.0));
        assertThat(warehouse.getFoods(), hasItem(egg));
        assertThat(shop.getFoods(), not(hasItem(egg)));
        assertThat(trash.getFoods(), not(hasItem(egg)));
    }

    @Test
    public void whenProductLife100AndMoveTrash() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(breadExpaireRate100);

        assertThat(breadExpaireRate100.getDiscount(), is(0.0));
        assertThat(trash.getFoods(), hasItem(breadExpaireRate100));
        assertThat(shop.getFoods(), not(hasItem(breadExpaireRate100)));
    }
}