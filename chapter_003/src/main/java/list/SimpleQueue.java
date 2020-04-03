package list;

/**
 * @author Sekator  : mail sekator778@gmail.com
 * очередь -> стеке стек -> линкедлисте
 */

public class SimpleQueue<E> {
    private SimpleStack<E> stackIn = new SimpleStack<>();
    private SimpleStack<E> stackOut = new SimpleStack<>();
    private int size;

    /**
     * этот метод удаляет и возвращает заголовок очереди.
     * Возвращает ноль, если очередь пуста
     * наша очередь тут не доделана она прокидывает ексепшн сверху пришедший
     * @return element
     */
    public E poll() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /**
     * этот метод используется для добавления элементов в конец очереди.
     * @param value element for add to Queue
     */
    public void add(E value) {
        size++;
        stackIn.push(value);
    }
}
