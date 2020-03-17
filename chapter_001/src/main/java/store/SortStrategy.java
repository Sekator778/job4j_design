package store;

/**
 * Общий интерфейс всех стратегий.
 */

public interface SortStrategy {
    boolean validate(Food food);
}
