package map;

import java.util.Map;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
        if (key != null ? !key.equals(mapEntry.key) : mapEntry.key != null) {
            return false;
        }
        return value != null ? value.equals(mapEntry.value) : mapEntry.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MapEntry{" + "key=" + key + ", value=" + value + '}';
    }
}
