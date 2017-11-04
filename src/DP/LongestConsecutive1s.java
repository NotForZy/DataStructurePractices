package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 03/11/2017.
 */
public class LongestConsecutive1s {
    public LongestConsecutive1s() {
        test();
    }

    private int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] helperArray = new int[array.length];
        helperArray[0] = array[0];
        int globalMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                helperArray[i] = helperArray[i - 1] + 1;
                if (helperArray[i] > globalMax) {
                    globalMax = helperArray[i];
                }
            } else {
                helperArray[i] = 0;
            }
        }

        return globalMax;
    }

    private void test() {
        int[] input = {0, 1, 0, 1, 1, 1, 0};
        int result = longest(input);
        System.out.println("The longest consecutive 1s is : " + result);
    }
}
