package array;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static array.Cinema.Place;

public class CinemaTest {

    @Test
    public void checkEmptyPlace() {
        Place[][] places = {
                {null, null, new Place(0, 2)},
                {null, new Place(1, 1), new Place(1, 2)},
                {new Place(2, 0), new Place(2, 1), new Place(2, 2)}
        };
        Place rsl = Cinema.checkEmptyPlace(places);
        Place expected = new Place(0, 0);
        assertThat(rsl, is(expected));
    }

    @Test
    public void checkEmptyPlaceIsNotNull() {
        Place[][] places = {
                {new Place(0, 0), null, new Place(0, 2), null, new Place(0, 4)},
                {null, new Place(1, 1), null, new Place(1, 3), null},
                {new Place(2, 0), null, null, null, new Place(2, 4)},
                {null, new Place(3, 1), null, new Place(3, 3), null},
                {new Place(4, 0), new Place(4, 1), new Place(4, 2), null, null}
        };
        Place rsl = Cinema.checkEmptyPlace(places);
        Place expected = new Place(2, 2);
        assertThat(rsl, is(expected));
    }

    @Test
    public void checkEmptyPlaceIsNull() {
        Place[][] places = {
                {new Place(0, 0), null, new Place(0, 2), null, new Place(0, 4)},
                {null, new Place(1, 1), null, new Place(1, 3), null},
                {new Place(2, 0), null, new Place(2, 2), null, new Place(2, 4)},
                {null, new Place(3, 1), null, new Place(3, 3), null},
                {new Place(4, 0), new Place(4, 1), new Place(4, 2), null, new Place(4, 4)}
        };
        Place rsl = Cinema.checkEmptyPlace(places);
        assertThat(rsl, is(nullValue()));
    }
}