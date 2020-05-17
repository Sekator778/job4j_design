package tictactoe;

/**
 * point to game field
 */

public class Point {
    private final int x;
    private final int y;
    private final boolean mark;

    public Point(int x, int y, boolean mark) {
        this.x = x;
        this.y = y;
        this.mark = mark;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        if (x != point.x) {
            return false;
        }
        if (y != point.y) {
            return false;
        }
        return mark == point.mark;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (mark ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        String rsl;
        if (this.mark) {
            rsl = "[X]";
        } else {
            rsl = "[0]";
        }
        return rsl;
    }
}
