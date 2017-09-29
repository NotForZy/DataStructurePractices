/**
 * project: Test
 *
 * @author YubaiTao on 29/09/2017.
 */
public class ClosestInSortedArray {
    public ClosestInSortedArray() {
        test();
    }

    private int binarySearch(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while (right - left > 1) {
            int mid = (left + right)/2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (Math.abs(input[left] - target) < Math.abs(input[right] - target) ) {
            return left;
        } else {
            return right;
        }
    }

    private void test() {
        int[] input = new int[] {1, 2, 3, 5, 6, 7, 8, 13};
        int result = binarySearch(input, 2);

        System.out.println("The closest one's index to the target is: " + result);
    }
}
