package BinarySearch;

/**
 * project: Test
 *
 * @author YubaiTao on 23/12/2017.
 *
 *
 * Given two sorted arrays of size m and n respectively,
 * you are tasked with finding the element that would be at the
 * k-th position of the final sorted array.
 *
 *
 * Original Link:
 *     https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 *
 *
 */
public class KthElementInTwoSortedArrays {
    public KthElementInTwoSortedArrays() {
        test();
    }

    // The time complexity should be constrained in O(logm + logn)
    private int findKth(int[] array1, int[] array2,
                       int start1, int start2,
                       int end1, int end2, int k) {
        if (start1 == end1) {
            return array2[k + start2];
        }
        if (start2 == end2) {
            return array1[k + start1];
        }
        int mid1 = (end1 - start1) / 2;
        int mid2 = (end2 - start2) / 2;
        if (mid1 + mid2 < k) {
            if (array1[mid1 + start1] > array2[mid2 + start2]) {
                return findKth(array1, array2,
                        start1, start2 + mid2 + 1,
                        end1, end2, k - mid2 - 1);
            } else {
                return findKth(array1, array2,
                        start1 + mid1 + 1, start2,
                        end1, end2, k - mid1 - 1);
            }
        } else {
            if (array1[mid1 + start1] > array2[mid2 + start2]) {
                return findKth(array1, array2,
                        start1, start2,
                        start1 + mid1, end2, k);
            } else {
                return findKth(array1, array2,
                        start1, start2,
                        end1, start2 + mid2, k);
            }
        }

    }

    // Divide And Conquer Approach 2
    // Time complexity O(logk)
    private int findKthEnhanced(int[] array1, int[] array2, int m, int n, int k, int st1, int st2) {
        // in case we have reached end of array 1
        if (st1 == m) {
            return array2[st2 + k - 1];
        }

        // in case we have reached end of array 2
        if (st2 == n) {
            return array1[st1 + k - 1];
        }

        // k should never reach 0 or exceed sizes of arrays
        if (k == 0 || k > (m - st1) + (n - st2)) {
            return -1;
        }

        // Compare first elements of arrays and return
        if (k == 1) {
            return (array1[st1] < array2[st2]) ? array1[st1] : array2[st2];
        }
        int curr = k / 2;

        // size of array 1 is less than k / 2
        if (curr - 1 >= m - st1) {
            // Last of element of array1 is not k-th
            // We can directly return the (k - m)th
            // element in array 2
            if (array1[m - 1] < array2[st2 + curr - 1]) {
                return array2[st2 + (k - (m - st1) - 1)];
            } else {
                return findKthEnhanced(array1, array2, m, n, k - curr, st1, st2 + curr);
            }
        }

        // size of array 2 is less than k / 2
        if (curr - 1 >= n - st2) {
            if (array2[n - 1] < array1[st1 + curr - 1]) {
                return array1[st1 + (k - (n - st2) - 1)];
            } else {
                return findKthEnhanced(array1, array2, m, n, k - curr, st1 + curr, st2);
            }
        } else {
            // Normal comparison, move starting index of one array k / 2 to the right
            if (array1[curr + st1 - 1] < array2[curr + st2 - 1]) {
                return findKthEnhanced(array1, array2, m, n, k - curr, st1 + curr, st2);
            } else {
                return findKthEnhanced(array1, array2, m, n, k - curr, st1, st2 + curr);
            }
        }

    }


    private void test(){
        int[] array1 = {2, 3, 6, 7, 9};
        int[] array2 = {1, 4, 8, 10};
        int k = 5;

        int result = findKth(array1, array2, 0, 0, array1.length, array2.length, k - 1);
        System.out.print("The " + k + "-th element of two arrays union is: " );
        System.out.println("\t" + result);

        System.out.println("--------------------------------------");

        int result2 = findKthEnhanced(array1, array2, array1.length, array2.length, k, 0, 0);
        System.out.print("The " + k + "-th element of two arrays union is: " );
        System.out.println("\t" + result2);
    }
}
