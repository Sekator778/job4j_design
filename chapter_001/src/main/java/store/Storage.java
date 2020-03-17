package store;

import java.util.List;

public interface Storage extends SortStrategy {

    void add(Food food);

    List<Food> getFood();

}
