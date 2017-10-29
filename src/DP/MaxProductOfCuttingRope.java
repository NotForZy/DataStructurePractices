package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 29/10/2017.
 *
 *
 * Given a rope with positive integer-length n,
 * how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1],
 * in order to get the maximal product of p[0]*p[1]* ... *p[m-1]?
 * m is determined by you and must be greater than 0 (at least one cut must be made).
 * Return the max product you can have.
 *
 * Assumptions: n >= 2
 *
 * Examples:
 *     n = 12, the max product if 3 * 3 * 3 * 3 = 81
 *     (cut the rope into 4 pieces with length of each is 3)
 *
 */
public class MaxProductOfCuttingRope {
    public MaxProductOfCuttingRope() {
        test();
    }

    // my own implementation
    private int maxProduct(int length) {
        if (length == 1 || length == 2) {
            return 1;
        }
        // start at index 1, easy for keep record
        int[] helperArray = new int[length + 1];
        helperArray[0] = 1;
        helperArray[1] = 1;
        // helperArray[2] = 1; wrong base case
        // because during the intermediate result, helper[2] should be 2, without cutting.
        for (int i = 2; i < length + 1; i++) {
            for (int j = 1; j < i; j++) {
                int cur =  Math.max((i - j)*helperArray[j], helperArray[j]*helperArray[i - j]);
                if (helperArray[i] < cur) {
                    helperArray[i] = cur;
                }
            }
            // remember to count self in to the comparision.
            if (length != i) {
                helperArray[i] = Math.max(helperArray[i], i);
            }
        }

//        for (int i = 0; i < helperArray.length; i++) {
//            System.out.print(" " + helperArray[i]);
//        }

        return helperArray[length];
    }

    private int maxProductII(int length) {
        if (length == 2) {
            return 1;
        }
        int[] array = new int[length + 1];
        array[1] = 1; // it does not matter if this element is 1 or 0
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
            // At least one of the partitions after cutting is <= i/2,
            // so we can just pick that partition, and find the maximum product.
            for (int j = 1; j <= i / 2; j++) {
                // For the other partition, we can choose not cutting it or
                // cutting it, so the max number we can get is either i - j or array[i - j]
                array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]) );
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(" " + array[i]);
//        }
        return array[length];
    }

    private void test() {
        int length = 12;
        int result = maxProduct(length);
        int result2 = maxProductII(length);
        System.out.println("The max product is: " + result + "; " + result2);
    }
}
