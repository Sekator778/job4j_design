package storage;

import org.junit.Test;
import store.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestStorage {
    @Test
    public void whenFoodAddToWarehouse() throws EmptyStorageException {
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(shop, warehouse, trash);
        LocalDate now = LocalDate.now();
        Food apple = new Apple(
                "SimpleApple", now.minus(Period.ofDays(5)), now.plus(Period.ofDays(50)), 100, 10);
        controlQuality.sortFood(apple);
        List<Food> result = warehouse.getFood();
        List<Food> expected = List.of(apple);
        assertThat(result, is(expected));

    }
}
