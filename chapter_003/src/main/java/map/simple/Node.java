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
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
