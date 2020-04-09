package list;

/**
 * очередь -> стеке стек -> линкедлисте
 */

public class SimpleQueue<E> {
    private SimpleStack<E> input = new SimpleStack<>();
    private SimpleStack<E> output = new SimpleStack<>();
    private int size;

    /**
     * этот метод удаляет и возвращает заголовок очереди.
     * Возвращает ноль, если очередь пуста
     * наша очередь тут не доделана она прокидывает ексепшн сверху пришедший
     * @return element
     */
    public E poll() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        size--;
        return output.pop();
    }

    /**
     * этот метод используется для добавления элементов в конец очереди.
     * @param value element for add to Queue
     */
    public void add(E value) {
        size++;
        input.push(value);
    }

    /**
     * return length queue
     * @return length
     */
    public int size() {
        return size;
    }
}
