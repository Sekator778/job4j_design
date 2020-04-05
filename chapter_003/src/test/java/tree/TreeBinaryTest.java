package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class TreeBinaryTest {
    private final Tree<Integer> tree = new Tree<>(1);

    @Test
    public void whenBinaryTree() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenNotBinaryTree() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        assertFalse(tree.isBinary());
    }



}
