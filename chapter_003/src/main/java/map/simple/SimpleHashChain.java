package map.simple;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleHashChain<K, V> implements Iterable<Node<K, V>> {
    public int size = 0; // only for test private should be here !!!
    private Node<K, V>[] nodes;
    private int modCount = 0;

    public SimpleHashChain() {
        this.nodes = (Node<K, V>[]) new Node[16];
    }

    /**
     *  calc hashcode
     * @param key object
     * @return int 10 number
     */
    private int hashCode(Object key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16); // ????
        }
        return h;
    }

    /**
     * calc index for our table
     * @param hash - hascode object
     * @return num cell table
     */
    private int index(int hash) {
        return hash & (nodes.length - 1);
    }

    /**
     * если ключ уже есть то возвращаем фолс
     * @param key - key
     * @param value - value
     * @return - try if add elem
     */
    public boolean put(K key, V value) {
        boolean rsl = false;
        if (size == nodes.length) {
            resize(size * 2);
        }
        int index = index(hashCode(key));
        Node<K, V> oldValue = nodes[index];
        if (oldValue == null) {
            nodes[index] = new Node<>(key, value);
            rsl = true;
            size++;
            modCount++;
        } else if (oldValue.getKey().equals(key)) {
            nodes[index] = new Node<>(key, value); // tyt можно не добавлять по условию а фолсить
            rsl = false;
        }
        return rsl;
    }

    /**
     *
     * @param key - key
     * @return value
     */
    public V get(K key) {
        int index = index(hashCode(key));
        V value = null;
        Node<K, V> node = nodes[index];
        if (node != null) {
            if ((node.getKey() == null && key == null) || (node.getKey() != null && node.getKey().equals(key))) {
                value = node.getValue();
            }
        }
        return value;
    }

    /**
     * delete el
     * @param key key
     * @return result
     */
    public boolean delete(K key) {
        boolean rsl = false;
        if (nodes.length > 0) {
            int index = index(hashCode(key));
            Node<K, V> node = nodes[index];
            if (node != null && node.getKey().equals(key)) {
                nodes[index] = null;
                size--;
                modCount++;
                rsl = true;
            }
        }
        return rsl;
    }

    private void resize(int size) {
        Node<K, V>[] beforeTable = nodes;
        nodes = (Node<K, V>[]) new Node[size];
        for (Node<K, V> node : beforeTable
             ) {
            K key = node.getKey();
            V value = node.getValue();
            int index = index(hashCode(key));
            nodes[index] = new Node<>(key, value);
        }
    }

    public int length() {
        return nodes.length;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new SimpleHashChainIterator();
    }

    private class SimpleHashChainIterator implements Iterator<Node<K, V>> {
        private Node<K, V> node = null;
        private int currentModCount = modCount;
        private int index = 0;

        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            if (index < nodes.length) {
                do {
                    node = nodes[index++];
                } while (node == null && index < nodes.length);
                hasNext = (node != null);
                index--;
            }
            return hasNext;
        }

        @Override
        public Node<K, V> next() {
            if (currentModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return nodes[index++];
        }
    }
}
