package cas;

/**
 * Compare AND Swap = сравнение и замены
 * Код, иллюстрирующий ход выполнения (но не характеристики) метода Сравнить и заменить
 *
 * Операция CAS включает 3 объекта-операнда: адрес ячейки памяти (V),
 * ожидаемое старое значение (A) и новое значение (B).
 * Процессор атомарно обновляет адрес ячейки, если новое значение совпадает со старым,
 * иначе изменений не зафиксируется. В любом случае, будет выведена величина,
 * которая предшествовала времени запроса. Некоторые варианты метода CAS просто сообщают,
 * успешно ли прошла операция, вместо того, чтобы отобразить само текущее значение.
 * Фактически, CAS только сообщает: "Наверное, адрес V равняется A; если так оно и есть,
 * поместите туда же B, в противном случае не делайте этого, но обязательно скажите мне,
 * какая величина - текущая."
 */

public class SimulatedCAS {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * базовый алгоритм
     * описание переменных выше
     * @param expectedValue А
     * @param newValue B
     * @return A
     */
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (value == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
}