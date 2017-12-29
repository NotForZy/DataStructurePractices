package BinarySearch;

/**
 * project: Test
 *
 * @author YubaiTao on 23/12/2017.
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
    public int findKth(int[] array1, int[] array2,
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

    private void test(){
        int[] array1 = {2, 3, 6, 7, 9};
        int[] array2 = {1, 4, 8, 10};
        int k = 8;

        int result = findKth(array1, array2, 0, 0, array1.length, array2.length, k - 1);
        System.out.print("The " + k + "-th element of two arrays union is: " );
        System.out.println("\t" + result);
    }
}
