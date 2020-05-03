package parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlaceTest {
    private Place placeDefaultSize;
    private Place placeCurrentSize;

    @Before
    public void init() {
        placeDefaultSize = new Place();
        placeCurrentSize = new Place(4);
    }

    /**
     * проверяем размер созданого паркоместа
     */
    @Test
    public void size() {
        assertThat(placeDefaultSize.size(), is(1));
        assertThat(placeCurrentSize.size(), is(4));
    }

    /**
     * проверяем свободна ли парковка
     * и как работает метод для занятия места и освобождения места
     */
    @Test
    public void isPlaceTaken() {
        assertFalse(placeCurrentSize.isPlaceTaken());
        placeCurrentSize.takenPlace();
        assertTrue(placeCurrentSize.isPlaceTaken());
        placeCurrentSize.freePace();
        assertFalse(placeCurrentSize.isPlaceTaken());
        new Place().resetNumberPlace();
    }

    /**
     * муторный тест ********
     * показывает номер паркоместа как увеличиваеться и уменьшаеться
     */
    @Test
    public void whenAddAutoParkingSizeGrow() {
        assertThat(placeDefaultSize.getNumberPlace(), is(1));
        assertThat(placeCurrentSize.getNumberPlace(), is(2));
        Place place = null;
        for (int i = 0; i < 23; i++) {
           place = new Place();
        }
        assertThat(place.getNumberPlace(), is(25));
        placeDefaultSize.deletePlace(place);
        place = new Place();
        assertThat(place.getNumberPlace(), is(25));
        new Place().resetNumberPlace();

    }
}