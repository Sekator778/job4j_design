package tictactoe;

import java.util.HashSet;
import java.util.Set;

/**
 * логика крестики нолики выиграш ничья или точка на поле
 */

public class Logic {
    private int size;
    private final Set<Point> field;

    public Logic(int size) {
        this.size = size;
        field = new HashSet<>(size);
    }

    public boolean addPoint(int x, int y, boolean mark) {
        int before = field.size();
        if (checkCoordinates(x, y)) {
            Point insert = new Point(x, y, mark);
            if (isFree(x, y)) {
                field.add(insert);
            }
        }
        int after = field.size();
        return after > before;
    }

    public Set<Point> getField() {
        return field;
    }

    public int getSize() {
        return size;
    }

    private boolean checkCoordinates(int x, int y) {
        return x < size && y < size;
    }

    private boolean isFree(int x, int y) {
        boolean rsl = true;
        for (Point p : field
        ) {
            if (p.getX() == x && p.getY() == y) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public boolean isWin() {
        boolean rsl = false;
        int[][] two = new int[size][size];
        int[][] one = new int[size][size];
        for (Point p : field
        ) {
            if (!checkCoordinates(p.getX(), p.getY())) {
                break;
            }
            if (field.size() < size) {
                break;
            } else {
                if (p.isMark()) {
                    one[p.getX()][p.getY()] = 1;
                } else {
                    two[p.getX()][p.getY()] = 2;
                }
            }
            if (hasWinner(one)) {
                System.out.println("win X");
                rsl = true;
                break;
            }
            if (hasWinner(two)) {
                System.out.println("win 0");
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public boolean deadHeat() {
        boolean rsl = false;
        if ((size * size) == field.size()) {
            rsl = true;
            System.out.println("dead Heat");
        }
        return rsl;
    }

    public boolean hasWinner(int[][] values) {
        boolean rsl = false;
        int count = 0;

        // gorizontal
        for (int[] x : values) {
            for (int k : x
            ) {
                if (k == 1 || k == 2) {
                    count++;
                }
                if (count == size) {
                    rsl = true;
                }
            }
            count = 0;
        }
        // vertical
        for (int x = 0; x < values.length; x++) {
            for (int[] value : values) {
                if (value[x] == 1 || value[x] == 2) {
                    count++;
                    if (count == size) {
                        rsl = true;
                    }
                }
            }
            count = 0;
        }
        // diagonal
        int k = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[k][k] == 1 || values[k][k] == 2) {
                k++;
                count++;
            }
            if (count == size) {
                rsl = true;
            }
        }
        return rsl;
    }
}
