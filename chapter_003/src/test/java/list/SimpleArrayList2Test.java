package list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayList2Test {

    private SimpleArrayList2<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList2<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElement() {
        assertThat(list.delete(), is(2));
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteWhenNotElementList() {
        SimpleArrayList2<Integer> list2 = new SimpleArrayList2<>();
        list2.delete();
    }
}