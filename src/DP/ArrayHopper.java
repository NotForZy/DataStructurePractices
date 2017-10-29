package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 29/10/2017.
 *
 *
 * Given an array A of non-negative integers,
 * you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from that position
 * (you can only jump towards the end of the array).
 * Determine if you are able to reach the last index.
 *
 * Assumptions:
 *     The given array is not null and has length of at least 1.
 *
 * Examples:
 *     {1, 3, 2, 0, 3}, we are able to reach the end of array (jump to index 1 then reach the end of the array)
 *     {2, 1, 1, 0, 2}, we are not able to reach the end of array.
 *
 */
public class ArrayHopper {
    public ArrayHopper() {
        test();
    }

    // my implementation,
    // induction goes from end to the first of the array
    private boolean canJump(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] helperArray = new boolean[array.length];
        for (boolean b : helperArray) {
            b = false;
        }
        helperArray[array.length - 1] = true;
        for (int i = array.length - 2; i > -1; i--) {
            for (int j = i; j < array.length && j < i + array[i] + 1; j++) {
                if (helperArray[j]) {
                    helperArray[i] = true;
                    break;
                }
            }
        }

//        for (int i = 0; i < helperArray.length; i++) {
//            System.out.print(" " + helperArray[i]);
//        }

        return helperArray[0];
    }

    // Another solution, induction goes by index ascending.
    // the refer is now the array[0], not array[end] anymore.
    private boolean canJumpII(int[] array) {
        boolean[] canJump = new boolean[array.length];
        // canJump[i] means from index 0, can jump to index i.
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // if index j is reachable from index 0, and from index j
                // it is possible to jump to index i.
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }

    private void test() {
        int[] array = {1, 3, 2, 0, 3};
        int[] array2 = {2, 1, 1, 0, 2};
        boolean result = canJump(array);
        boolean result2 = canJumpII(array2);
        System.out.println(result2 ? "Can jump to the end." : "Nope.");
    }
}
