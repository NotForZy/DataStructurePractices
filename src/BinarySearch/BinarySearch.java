package BinarySearch;

/**
 * project: Test
 *
 * @author YubaiTao on 29/09/2017.
 *
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index i such that A[i] == T or return -1 if there is no such index.
 *
 *
 * Binary Search is to:
 *     1. Reduce the search space by one half
 *        (Note that it's NOT necessarily the case that you halve the array)
 *        according specific logic rules.
 *     2. Guarantee the targe must remain in the remaining part.
 *        (Can not be rule out accidently)
 *
 *
 */
public class BinarySearch {
    public BinarySearch() {
        test();
    }

    private int search(int[] input, int target) {
        if (input == null) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private void test() {
        int[] input = new int[] {1, 2, 4, 5, 6, 8, 12, 24, 27, 54, 67 };
        int[] input2 = new int[] {53};
        int result = search(input2, 53);

        System.out.println("The Binary Search Result is: " + result);
    }
}
