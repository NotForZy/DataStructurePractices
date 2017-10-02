/**
 * project: Test
 *
 * @author YubaiTao on 02/10/2017.
 */
public class KClosestInSortedArray {
    public KClosestInSortedArray() {
        test();
    }

    private int[] binarySearch(int[] array, int target, int k) {
        int[] result = new int[k];
        int left = 0;
        int right = array.length - 1;
        int breakPoint = -1;
        int count;
        if (k == 0) {
            int[] empty = new int[]{};
            return empty;
        }
        if (k > array.length) {
            return array;
        }
        while ((right - left) > 1) {
            int mid = (left + right)/2;
            if (array[mid] == target) {
              breakPoint = mid;
              // System.out.println("mid : " + array[mid]);
              break;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println("*** Left: " + left + "   Right: " + right);
        if (breakPoint == -1) {
            if (Math.abs(array[left] - target) > Math.abs(array[right] - target)) {
                breakPoint = right;
            } else {
                breakPoint = left;
            }
        }
        result[0] = array[breakPoint];
        count = 1;
        if (breakPoint == 0) {
            left = breakPoint;
        } else if (breakPoint == array.length - 1) {
            right = breakPoint;
        } else {
            left = breakPoint - 1;
            right = breakPoint + 1;
        }
        System.out.println("Left: " + left + "   Right: " + right);
        System.out.println("Breaking Point:" + breakPoint);

        while (count < k) {
            if (left < 0 || left == breakPoint) {
                result[count] = array[right];
                right++;
                count++;
                continue;
            }
            if (right > array.length - 1 || right == breakPoint) {
                result[count] = array[left];
                left--;
                count++;
                continue;
            }
            if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
                result[count] = array[left];
                left--;
                count++;
            } else {
                result[count] = array[right];
                right++;
                count++;
            }
        }

        return result;
    }

    private void test() {
        int[] input = new int[] {1, 4, 6, 8};
        int[] input2 = new int[] {1, 5};
        int[] result = binarySearch(input2, 10, 2);
        System.out.print("The result is: ");
        for (int i = 0; i< result.length; i++) {
            System.out.print(" " + result[i]);
        }
    }
}
