package stack;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleStack2Test {

    @Test
    public void push() {
        SimpleStack2<Integer> stack = new SimpleStack2<>(10);
        assertTrue(stack.empty());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertThat(stack.peek(), is(4));
        assertThat(stack.pop(), is(4));
        assertThat(stack.peek(), is(3));
    }

    @Test
    public void pop() {
        SimpleStack2<Integer> stack = new SimpleStack2<>(10);
        assertTrue(stack.empty());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));


    }

    @Test
    public void peek() {
        SimpleStack2<Integer> stack = new SimpleStack2<>(10);
        assertTrue(stack.empty());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertThat(stack.peek(), is(2));
        assertThat(stack.peek(), is(2));

    }

    @Test
    public void isEmpty() {
        SimpleStack2<Integer> stack = new SimpleStack2<>(10);
        assertTrue(stack.empty());
    }

    @Test(expected = EmptyStackException.class)
    public void whenPopIsEmptyStack() {
        SimpleStack2<Integer> stack = new SimpleStack2<>(10);
        assertThat(stack.pop(), is(23));
    }
}