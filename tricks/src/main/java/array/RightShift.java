package array;

import java.util.Arrays;

/**
 * Ваша задача выполнить циклический сдвиг вправо с шагом count
 * <p>
 * Например,
 * <p>
 * {1, 2, 3, 4, 5}, count = 1 => {5, 1, 2, 3, 4}
 * <p>
 * {1, 2, 3, 4, 5}, count = 2 => {4, 5, 1, 2, 3}
 *
 * как то избыточно
 */
public class RightShift {

    public static void shift(int[] nums, int count) {
        for (int i = 0; i < count; i++) {
            shift(nums);
        }
    }

    // метод делает сдвиг с шагом 1
    private static void shift(int[] nums) {
        int tmp;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = tmp;
        }
    }
}