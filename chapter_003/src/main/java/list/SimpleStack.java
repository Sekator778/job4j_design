package list;

import java.util.EmptyStackException;

/**
 * https://www.geeksforgeeks.org/stack-class-in-java/
 * мойте посуду и тогда узнаете что такое стек)
 *
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleStack<E> {
    private int size = 0;
    private SimpleLinkedList<E> linked = new SimpleLinkedList<>();

    /**
     * помещает элемент на вершину стека
     * @param value element
     */
    public void push(E value) {
        size++;
        linked.add(value);
    }

    /**
     * удаляет и возвращает верхний элемент стека.
     * Исключение 'EmptyStackException' генерируется,
     * если мы вызываем pop (), когда вызывающий стек пуст.
     * @return element
     */
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        size--;
        return linked.deleteLast();
    }

    /**
     * возвращает true, если на вершине стека ничего нет.
     * Остальное возвращает false.
     * @return result
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * возвращает элемент в верхней части стека, но не удаляет его
     * @return element
     */
    public E peek() {
        E rsl = null;
        for (E e : linked
             ) {
            rsl = e;
        }
        return rsl;
    }

    /**
     * определяет, существует ли объект в стеке.
     * Если элемент найден, он возвращает позицию элемента с вершины стека. Иначе, это возвращает -1.
     * @param element искомый елемент
     * @return position element to stack or -1 if no find
     */
    public int search(E element) {
        int rsl = size;
        for (E e : linked
        ) {
            rsl--;
            if (e.equals(element)) {
                return rsl;
            }
        }
        return --rsl;
    }
}