package generic;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> array;

    public AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndexById(id);
        if (index == -1) {
            return false;
        }
        model.setId(id);
        array.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return array.remove(array.getIndex(findById(id)));
    }

    @Override
    public T findById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        } else {
            return array.get(index);
        }
    }

    private int getIndexById(String id) {
        return array.indexBy(el -> el.getId().equals(id));
    }
}
