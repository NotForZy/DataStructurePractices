package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 01/11/2017.
 */
public class ArrayHopperMinJump {
    public ArrayHopperMinJump() {
        test();
    }

    private int minJump(int[] array) {
        int[] jumpCount = new int[array.length];
        // base case
        jumpCount[array.length - 1] = 0;
        for (int i = array.length - 2; i > -1; i--) {
            getMinJump(jumpCount, i, array[i]);
        }

        return jumpCount[0]==Integer.MAX_VALUE ? -1 : jumpCount[0];
    }

    private void getMinJump(int[] jumpCount, int index, int maxStride) {
        jumpCount[index] = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < index + 1 + maxStride && i < jumpCount.length; i++) {
            if (jumpCount[i] < min) {
                min = jumpCount[i];
            }
        }
        if (min == Integer.MAX_VALUE) {
            jumpCount[index] = min;
            return;
        }
        jumpCount[index] = min + 1;
    }

    private void test() {
        int[] input = {3, 3, 1, 0, 4};
        int[] input2 = {2, 1, 1, 0, 2};

        int result = minJump(input);
        System.out.println("The result is : " + result);
    }
}
