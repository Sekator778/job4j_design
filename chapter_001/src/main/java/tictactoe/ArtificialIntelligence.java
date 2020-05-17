package tictactoe;

import java.util.Random;
import java.util.Set;

/**
 * рандомно ходит компьютер по полю
 */

public class ArtificialIntelligence {
    private final Dialog dialog = new Dialog();

    public Point moveAI(Set<Point> field, boolean flag, int size) {
        dialog.writeMessage("AI moves");
        Point rnd;
        rnd = generate(size, flag);
        while (unique(field, rnd)) {
            rnd = generate(size, flag);
        }
        return rnd;
    }

    private Point generate(int size, boolean flag) {
        Random random = new Random();
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        return new Point(x, y, flag);
    }

    private boolean unique(Set<Point> field, Point point) {
        boolean rsl = false;
        for (Point p : field
             ) {
            if (p.getX() == point.getX() && p.getY() == point.getY()) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
