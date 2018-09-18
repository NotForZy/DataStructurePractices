package BinarySearch;

/**
 * project: Test
 *
 * @author YubaiTao on 29/09/2017.
 *
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index of the first occurrence of T in A or return -1 if there is no such index.
 *
 */
public class FirstOccurrence {
    public FirstOccurrence() {
        test();
    }

    private int binarySearch(int[] input, int target) {
        int left = 0, right = input.length - 1;
        int mid;
        // Go out of loop when:
        //     left and right are neighbors
        while (left < right - 1) {
            mid  = left + (right - left)/2;
            if (input[mid] == target) {
                right = mid; // mid - 1 WRONG
            } else if (input[mid] < target){
                left = mid + 1; // left = mid RIGHT
            } else {
                right = mid - 1; // right = mid RIGHT
            }
        }
        if (input[left] == target) {
            return left;
        }
        if (input[right] == target) {
            return right;
        }
        return -1;
    }

    private void test() {
        int[] input = new int[] {1, 2, 2, 2, 3, 4, 4, 5};
        int result = binarySearch(input, 4);

        System.out.println("The index of the first occurrence of target is: " + result);
    }
}
