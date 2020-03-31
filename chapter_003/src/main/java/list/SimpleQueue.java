package list;

/**
 * @author Sekator  : mail sekator778@gmail.com
 * очередь -> стеке стек -> линкедлисте
 */

public class SimpleQueue<E> {
    private SimpleStack<E> stack = new SimpleStack<E>();

    public E poll() {
        return stack.removeFirst();
    }

    public void push(E value) {
        stack.push(value);
    }
}
