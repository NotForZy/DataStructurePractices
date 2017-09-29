/**
 * project: Test
 *
 * @author YubaiTao on 29/09/2017.
 */
public class LastOccurrence {
    public LastOccurrence() {
        test();
    }

    private int binarySearch(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int left = 0;
        int right = input.length;
        while (right - left > 1) {
            int mid = (left + right)/2;
            if (input[mid] == target) {
                left = mid;
            } else if (input[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (input[right] == target) {
            return right;
        }
        if (input[left] == target) {
            return left;
        }
        return -1;
    }

    private void test() {
        int[] input = new int[] {1, 2, 2, 2, 3, 4, 4, 5};
        int result = binarySearch(input, 4);

        System.out.println("The index of the last occurrence of target is: " + result);
    }
}
