package array;

/**
 * Дан массив чисел, нужно найти сумму разниц пар элементов
 * Например,
 * {10, 2, 1} => (10 - 2) + (2 - 1) = 9
 * {5, 4, 3, 2, 1} => {(5 - 4) + (4 - 3) + ( 3 - 2) + (2 - 1)}
 * {15, 10, 5} => (15 - 10) + (10 - 5) => 10
 */
public class SumOfDifferences {
    public static int sum(int[] nums) {
        int sum = 0, left, right;
        for (int i = 0; i < nums.length - 2;) {
            left = nums[i] - nums[++i];
            right = nums[i] - nums[++i];
            sum += (left + right);
        }
        return sum;
    }
}