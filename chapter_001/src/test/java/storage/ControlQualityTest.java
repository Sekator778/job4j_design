//package storage;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import store.ControllQuality;
//import store.foods.Apple;
//import store.foods.Bread;
//import store.foods.Egg;
//import store.foods.Food;
//import store.storage.Shop;
//import store.storage.Storage;
//import store.storage.Trash;
//import store.storage.Warehouse;
//
//import java.lang.reflect.Constructor;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;
//
//public class ControlQualityTest {
//
//    private final LocalDate now = LocalDate.now();
//    private Storage warehouse;
//    private Storage shop;
//    private Storage trash;
//    private ControllQuality control;
//
//    @Before
//    public void before() {
//        shop = new Storage(new Shop());
//        warehouse = new Storage(new Warehouse());
//        trash = new Storage(new Trash());
//        control = new ControllQuality(List.of(warehouse, shop, trash));
//    }
//
//    @Test
//    public void whenResortAfterSomeDaysPassedThenFoodIsRedistributed() {
//        Apple apple = new Apple("apple", now.minus(Period.ofDays(0)), now.plus(Period.ofDays(500)), 3.0, 0.0);
//        Bread bread = new Bread("bread", now.minus(Period.ofDays(5)), now.plus(Period.ofDays(15)), 7.0, 0.0);
//        Egg egg = new Egg("egg1", now.minus(Period.ofDays(4)), now.plus(Period.ofDays(1)), 1.2, 0.2);
//        Egg egg1 = new Egg("egg2", now.minus(Period.ofDays(2)), now.plus(Period.ofDays(-1)), 1.1, 0.0);
//
//        control.sort(List.of(apple, bread, egg, egg1));
//        assertFalse(shop.checkStore(bread));
//        assertTrue(warehouse.checkStore(apple));
//        assertTrue(shop.checkStore(egg));
//        assertThat(egg.getDiscount(), is(0.2));
//        assertTrue(trash.checkStore(egg1));
//
//        LocalDate twoDaysHavePassed = now.plusDays(2);
//        control.resort();
//        assertTrue(warehouse.isEmpty());
//        assertThat(shop.takeAll(), containsInAnyOrder(apple, bread));
//        assertThat(bread.getDiscount(), is(0.3));
//        assertThat(trash.takeAll(), containsInAnyOrder(egg, egg1));
//    }
//}