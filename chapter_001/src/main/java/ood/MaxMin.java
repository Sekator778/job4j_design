package ood;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        value.sort(comparator.reversed());
        return value.get(0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        value.sort(comparator);
        return value.get(0);
    }
}