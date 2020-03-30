package list;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleStack<E> {
    private SimpleLinkedList<E> linked = new SimpleLinkedList<E>();

    public E poll() {
        return linked.deleteLast();
    }

    public void push(E value) {
        linked.add(value);
    }
}