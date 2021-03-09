package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnomalyTest {
    @Test
    public void whenNoAnomaly() {
        int[][] expect = {};
        int[] data = {5, 10, 15};
        int up = 16;
        int down = 4;
        assertArrayEquals(expect, Anomaly.found(data, up, down));
    }

    @Test
    public void whenOneAnomalyInPoint() {
        int[][] expect = {new int[] {1, 1}};
        int[] data = {5, 16, 15};
        int up = 16;
        int down = 4;
        int[][] out = Anomaly.found(data, up, down);
        assertArrayEquals(expect, out);
    }

    @Test
    public void whenOneAnomalyInPointInDiapason() {
        int[][] expect = {new int[] {1, 2}};
        int[] data = {5, 16, 17, 15};
        int up = 16;
        int down = 4;
        assertArrayEquals(expect, Anomaly.found(data, up, down));
    }

    @Test
    public void whenTwoAnomalyInPointInDiapason() {
        int[][] expect = {new int[] {1, 2}, new int[] {5, 6}};
        int[] data = {5, 16, 17, 15, 10, 1, 2};
        int up = 16;
        int down = 4;
        int[][] out = Anomaly.found(data, up, down);
        assertArrayEquals(expect, out);
    }
}