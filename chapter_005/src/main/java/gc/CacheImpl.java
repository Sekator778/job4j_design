package gc;

public interface CacheImpl<K, V> {
    V getValue(K key);
}
