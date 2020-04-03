package list;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleStackTest {

    @Test
    public void whenPushThenPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop(), is(1));
    }

    @Test(expected = EmptyStackException.class)
    public void whenPollOverSize() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.pop();
    }

    @Test
    public void whenPushPushThenPeekPeek() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        assertThat(stack.peek(), is(2));
        assertThat(stack.peek(), is(2));
    }

    @Test(expected = EmptyStackException.class)
    public void whenStackEmptyShouldException() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.pop();
    }

    @Test
    public void whenTestEmptyList() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        assertTrue(stack.empty());
    }
    @Test
    public void whenTestSearchElementShouldPositionReturn() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.search(1), is(3));
        assertThat(stack.search(2), is(2));
        assertThat(stack.search(3), is(1));
        assertThat(stack.search(4), is(0));
    }

    @Test
    public void whenTestSearchElementShouldReturnNegative() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.search(23), is(-1));
    }

}