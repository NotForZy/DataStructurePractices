package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 29/10/2017.
 *
 *
 * Given an unsorted array, find the length of the longest subarray in which
 * the numbers are in ascending order.
 *
 */
public class LongestAscendingSubArray {
    public LongestAscendingSubArray() {
        test();
    }

    // my own implementation
    private int longest(int[] array) {
        if (array == null) {
            return -1;
        }
        // case for new int[]{}
        if (array.length == 0) {
            return 0;
        }
        int[] helperArray = new int[array.length];
        helperArray[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                helperArray[i] = helperArray[i - 1] + 1;
            } else {
                helperArray[i] = 1;
            }
        }
        int max = -1;
        for (int i : helperArray) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int longestII(int[] array) {
        // Assumptions: the given array is not null.
        if (array.length == 0) {
            return 0;
        }
        // dp[i] = 1         (array[i] <= array[i - 1]
        //       = dp[i - 1] (array[i] >  array[i - 1]
        // So we can make the space consumption more efficient
        // by only recording the latest dp[i].
        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                // the second case, we can update dp[i]
                cur++;
                result = Math.max(result, cur);
            } else {
                // the first case, we need to rest dp[i].
                cur = 1;
            }
        }
        return result;
    }

    private void test() {
        int[] array = {7, 2, 3, 1, 5, 8, 9, 6};
//        int[] array = new int[]{};
        int result = longest(array);
        int result2 = longestII(array);
        System.out.println("The longest sub-array's length is: " + result +"; " + result2);
    }
}
