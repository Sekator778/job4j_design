package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestIterator {
    public static void main(String[] args) {
        // i nod
        // < i prev
        // i > next
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println("list start: " + list.toString());

        ListIterator<String> iterator = list.listIterator();
        String rsl = iterator.next(); // 0 -i> 1 - 2 - 3
        System.out.println("1 next: " + rsl);
        rsl = iterator.next();  // 0 - 1 -i> 2 - 3
        System.out.println("2 next: " + rsl);
        rsl = iterator.next();  // 0 - 1 - 2 -i> 3
        System.out.println("3 next: " + rsl);
        rsl = iterator.previous(); // 0 - 1 - 2 -i> 3
        System.out.println("1 previous: " + rsl);
        iterator.remove();

        System.out.println("after remove "  + list.toString());
    }
}
