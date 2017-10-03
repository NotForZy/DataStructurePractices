import java.util.Dictionary;
import java.util.Hashtable;

/**
 * project: Test
 *
 * @author YubaiTao on 02/10/2017.
 */
public class SearchInUnknownSizeSortedArray {
    public SearchInUnknownSizeSortedArray() {
        test();
    }

    private int binarySearch(Dictionary dict, int target) {
        // int power = 0;
        int i = 1;
        while (dict.get(i - 1) != null) {
            i = 2*i;
            // power++;
        }
//        System.out.println("i: " + i);

        int left = 0;
        int right = i - 1;
        while ((right - left) > 1){
            int mid = (left + right)/2;
            if (dict.get(mid) == null) {
                right = mid;
                continue;
            }
            int midValue = (Integer)dict.get(mid);
//            System.out.println("mid: " + mid);
//            System.out.println("midValue: " + midValue);
            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
//        System.out.println("left: " + left);
//        System.out.println("right: " + right);
        if (dict.get(left) != null && (Integer)dict.get(left) == target) {
            return left;
        }
        if (dict.get(right) != null && (Integer)dict.get(right) == target) {
            return right;
        }

        return  -1;
    }

    private int binarySearchOptimized(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        // find the right boundary for binary search
        // extends until we are sure the target is within the [left, right] range.
        while (dict.get(right) != null && (Integer)dict.get(right) < target) {
            // 1. move left to right
            // 2. double right index
            left = right;
            right = 2*right;
        }

        // classical binary search
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (dict.get(mid) == null) {
                right = mid - 1;
                continue;
            }
            int midValue = (Integer)dict.get(mid);
            if (midValue > target) {
                right = mid - 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private void test() {
        Hashtable<Integer, Integer> dict = new Hashtable<>();
        Hashtable<Integer, Integer> dict2 = new Hashtable<>();
        dict2.put(0, 1);
        for (int i = 0; i < 100000; i++) {
            dict.put(i, i);
        }
        int result = binarySearch(dict, 99999);
        int resultOptimized = binarySearchOptimized(dict, 99999);
        System.out.println("The result is: " + result);
        System.out.println("The optimized result is: " + resultOptimized);
    }
}
