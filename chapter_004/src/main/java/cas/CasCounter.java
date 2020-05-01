package cas;

/**
 *  Реализация счетчика с методом Сравнение и замена
 */

public class CasCounter {
    private final SimulatedCAS value;

    public CasCounter(SimulatedCAS value) {
        this.value = value;
    }

    public int getValue() {
        return value.getValue();
    }

    public int increment() {
        int oldValue = value.getValue();
        while (value.compareAndSwap(oldValue, oldValue + 1) != oldValue) {
            oldValue = value.getValue();
        }
        return oldValue + 1;
    }
}