package BinarySearch;

/**
 * project: Test
 *
 * @author YubaiTao on 23/12/2017.
 */
public class KthElementInTwoSortedArrays {
    public KthElementInTwoSortedArrays() {
        test();
    }

    // The time complexity should be constrained in O(logm + logn)
    public int findKth(int[] array1, int[] array2, int k) {
        if (array1.length == 0) {
            return array1[0];
        }
        if (array2.length == 0) {
            return array2[0];
        }

        return 0;
    }

    private void test(){
        int[] array1 = {2, 3, 6, 7, 9};
        int[] array2 = {1, 4, 8, 10};
        int k = 5;

        int result = findKth(array1, array2, k);
        System.out.println("The " + k + "-th element of two arrays union is: " );
        System.out.println("\t" + result);
    }
}
