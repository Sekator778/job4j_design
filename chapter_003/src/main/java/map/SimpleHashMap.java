package map;

import list.SimpleLinkedList;

import java.util.*;

/**
 * некоторые методы или переменные добавлены или уровень оступа шире чем надо
 * для того чтобы видеть что внутри происходит
 * как вот метод getCount -- Size
 *
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleHashMap<K, V> {
    static int size = 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int count;
    private int threshold;
    SimpleLinkedList<MapEntry<K, V>>[] buckets = new SimpleLinkedList[size];

    public int getCount() {
        return count;
    }

    public SimpleHashMap() {
        this.threshold = (int) (size * DEFAULT_LOAD_FACTOR);
    }

    /**
     * размер нашей мапы общий
     *
     * @return количество всех ячеек
     */
    public int size() {
        return size;
    }

    /**
     * вывод карты на экран
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (buckets[i] == null) {
                continue;
            } else {
                sb.append(i);
                buckets[i].forEach(x -> sb.append(x.toString()).append(" next nod "));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * хеш - функция
     */
    public int hash(Object key) {
        int h;
        if (key == null) {
            return 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    public int index(K key) {
        return (buckets.length - 1) & hash(key);
    }

    /**
     * тут надо подкоректировать так как по условию замены нету
     * можно возвращать булен
     * вообщем упростить
     *
     * @param key   - key
     * @param value - value
     * @return - value delete elem
     */
    public V put(K key, V value) {
        if (count > threshold) {
            resize();
        }
        V oldValue = null;
        int index = index(key);
        if (buckets[index] == null) {
            buckets[index] = new SimpleLinkedList<MapEntry<K, V>>();
        }
        SimpleLinkedList<MapEntry<K, V>> bucket = buckets[index]; // наш лист на нодах держит внутри в ноде мап энтри прикольно public static interface Map.Entry<K,V>
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        Iterator<MapEntry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> iPair = iterator.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                // тут замена должна быть
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
            oldValue = value;
            count++;
        }
        return oldValue;
    }

    private void resize() {
        size *= 2;
        SimpleLinkedList<MapEntry<K, V>>[] oldBuckets = buckets;
        buckets = new SimpleLinkedList[size];
        count = 0;
        for (SimpleLinkedList<MapEntry<K, V>> bucket : oldBuckets
        ) {
            if (bucket != null) {
                for (MapEntry<K, V> pair : bucket
                ) {
                    put(pair.getKey(), pair.getValue());
                }
            }
        }
        threshold = (int) (size * DEFAULT_LOAD_FACTOR);
    }

    /**
     * получение елемента по ключу
     */
    public V get(K key) {
        int index = index(key);
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]
        ) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        V rsl = null;
        if (buckets.length > 0) {
            int index = index(key);
            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i).getKey().equals(key)) {
                    rsl = buckets[index].get(i).getValue();
                    buckets[index].remove(i);
                    count--;
                    break;
                }
            }
        }
        return (V) rsl.toString();
    }

    /**
     * получение внутреннего множества
     */
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (SimpleLinkedList<MapEntry<K, V>> bucket : buckets
        ) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K, V> mpair : bucket
            ) {
                set.add(mpair);
            }
        }
        return set;
    }
}
