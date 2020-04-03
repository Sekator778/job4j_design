package map.simple;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class Node<K, V> {
    private final K key;
    private final V value;


    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?, ?> node = (Node<?, ?>) o;

        if (key != null ? !key.equals(node.key) : node.key != null) {
            return false;
        }
        return value != null ? value.equals(node.value) : node.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
