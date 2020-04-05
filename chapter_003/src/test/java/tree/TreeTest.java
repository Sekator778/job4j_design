package tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddElementButParentNotPresent() {
        Tree<Integer> tree = new Tree<>(1);
        assertFalse(tree.add(23, 3));
    }

    @Test
    public void whenAddElementButParentElementPresent() {
        Tree<Integer> tree = new Tree<>(1);
        assertFalse(tree.add(1, 1));
    }

    @Test
    public void whenAddElementButElementPresent() {
        Tree<Integer> tree = new Tree<>(1);
        assertTrue(tree.add(1, 23));
        assertFalse(tree.add(1, 23));
    }
}