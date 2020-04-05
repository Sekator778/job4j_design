package post;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class Node<T> {
    private Node<T> next;
    private T value;


    public Node(Object o) {
        this.value = (T) o;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
