package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 03/11/2017.
 *
 *
 * Given an unsorted integer array, find teh subarray that has the greastest sum.
 * Return the sum.
 *
 */
public class LargestSubArraySum {
    public LargestSubArraySum() {
        test();
    }

    private int largestSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] helperArray = new int[array.length];
        int globalMax = array[0];
        helperArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (helperArray[i - 1] < 0) {
                helperArray[i] = array[i];
            } else {
                helperArray[i] = array[i] + helperArray[i - 1];
            }
            if (helperArray[i] > globalMax) {
                globalMax = helperArray[i];
            }
        }

        return globalMax;
    }

    private void test() {
        int[] input = {2, -1, 4, -2, 1}; // result = 5
        int[] input2 = {-2, -1, -3}; // result = -1
        int result = largestSum(input2);
        System.out.println("The largest sub-array sum is : " + result);
    }
}
