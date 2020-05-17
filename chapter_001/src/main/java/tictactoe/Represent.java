package tictactoe;

import java.util.Set;

/**
 * вывод на экран
 */

public class Represent implements View {
    @Override
    public void view(Set<Point> field, int size) {
        boolean check = false;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (Point p : field
                ) {
                    if (p.getX() == x && p.getY() == y) {
                        check = true;
                        System.out.print(p);
                    }
                }
                if (!check) {
                    System.out.print("[ ]");
                }
                check = false;
            }
            System.out.println();
        }
    }
}
