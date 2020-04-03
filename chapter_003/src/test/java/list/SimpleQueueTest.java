package list;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleQueueTest {

    @Test
    public void whenPushAndPollElement() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        queue.add(4);
        queue.add(5);
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));
    }

    @Test(expected = EmptyStackException.class)
    public void whenEmptyQueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.poll();
    }

}
