package iterator.multiiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MultiIterator {
    /**
     * в итераторе внутри итераторы
     * Iterator<Iterator<Integer>> - это метод который пробегает по итераторам Iterator<Integer>

     * вот тут главное  =
     *  (new ArrayList<Integer>()).iterator(); --- Возвращает итератор для элементов в этом списке
     *  в правильной последовательности
     *  получили его и
     * @param it колекция (лист итераторов)
     * @return - все что было внутри
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {

            private Iterator<Integer> iterator = (new ArrayList<Integer>()).iterator();

            @Override
            public boolean hasNext() {

                while (it.hasNext() && !iterator.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() {

                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}