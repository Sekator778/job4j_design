package set;

import list.SimpleArrayList;

import java.util.Iterator;

/**
 * @author Sekator  : mail sekator778@gmail.com
 *
 * наш сет просто базируеться на SimpleArrayList
 * и можно взять все его методы как return values.iterator();
 * ньюанс -- Коллекция не должна хранить дубликаты.
 */

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArrayList<E> values = new SimpleArrayList<>(10);

    public boolean add(E object) {
        boolean rsl = contains(object);
        if (!rsl) {
            values.add(object);
        }
        return rsl;
    }

    private boolean contains(E object) {
        boolean rsl = false;
        for (E e : values
        ) {
            if (e.equals(object)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return values.iterator();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
