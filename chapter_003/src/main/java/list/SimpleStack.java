package list;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleStack<E> {
    private SimpleLinkedList<E> linked = new SimpleLinkedList<>();

    public E poll() {
        return linked.deleteLast();
    }

    public void push(E value) {
        linked.add(value);
    }

    public E removeFirst() {
        return linked.remove(0);
    }

}