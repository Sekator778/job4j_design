package stack;

import java.util.EmptyStackException;

/**
 * тут изи стек для лохов на собес
 * он корявый так как мы удаляем а елемент в масиве остаеться г)
 *
 * @author Sekator  : mail sekator778@gmail.com
 */

public class SimpleStack2<T> {

    private int maxSize;
    private Object[] stackArray;
    private int top;

    public SimpleStack2(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }

    /**
     * помещает элемент на вершину стека
     * @param value - value
     * @return try if add
     */
    public boolean push(T value) {
        stackArray[++top] = value;
        return true;
    }

    /**
     *  удаляет и возвращает верхний элемент стека
     *  EmptyStackException' генерируется, если мы вызываем pop (),
     *  когда вызывающий стек пуст.
     * @return element value
     */
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return (T) stackArray[top--];
    }

    /**
     * возвращает элемент в верхней части стека, но не удаляет его
     * @return element
     */
    public T peek() {
        return (T) stackArray[top];
    }

    /**
     * возвращает true, если на вершине стека ничего нет.
     * Остальное возвращает false.
     * @return result
     */
    public boolean empty() {
        return top == -1;
    }
}
