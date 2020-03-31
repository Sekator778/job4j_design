package list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleQueueTest {

    @Test
    public void whenPushAndPollElement() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenEmptyQueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.poll();
    }
}
