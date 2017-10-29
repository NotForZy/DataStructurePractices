package HashTable;

import java.util.*;

/**
 * project: Test
 *
 * @author YubaiTao on 29/10/2017.
 *
 * Find all numbers that appear in both of two sorted arrays
 * (the two arrays are all sorted in ascending order).
 *
 *
 * Assumptions:
 *    In each of the two sorted arrays, there could be duplicate numbers.
 *    Both two arrays are not null.
 *
 * Examples:
 *    A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6},
 *    common numbers are [1, 1, 2]
 *
 */
public class CommonNumbersOfTwoSortedArrays {
    public CommonNumbersOfTwoSortedArrays() {
        test();
    }

    // HashMap implementation
    private List<Integer> common(int[] A, int[] B) {
        List<Integer> common = new ArrayList<>();

        HashMap<Integer, Integer> countA = new HashMap<>();
        for (int num : A) {
            Integer ct = countA.get(num);
            if (ct != null) {
                countA.put(num, ct + 1);
            } else {
                countA.put(num, 1);
            }
        }

        HashMap<Integer, Integer> countB = new HashMap<>();
        for (int num : B) {
            Integer ct = countB.get(num);
            if (ct != null) {
                countB.put(num, ct + 1);
            } else {
                countB.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB != null) {
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < appear; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }

    // Two pointers implementation
    // using the "sorted" property.
    private List<Integer> commonII(int[] a, int[] b) {
        // Assumptions: a, b is not null.
        List<Integer> common = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                common.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    private void test() {
        int[] arrayA = {1, 1, 2, 2, 3};
        int[] arrayB = {1, 1, 2, 5, 6};
//        Integer[] arrayA = {1, 1, 2, 2, 3};
//        Integer[] arrayB = {1, 1, 2, 5, 6};
//        List<Integer> A = Arrays.asList(arrayA);
//        List<Integer> B= Arrays.asList(arrayB);

        List<Integer> result = common(arrayA, arrayB);
        List<Integer> result2 = commonII(arrayA, arrayB);
        System.out.println("The result is :");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(" "  + result.get(i));
        }
        System.out.println();
        for (int i = 0; i < result2.size(); i++) {
            System.out.print(" "  + result2.get(i));
        }
    }
}
