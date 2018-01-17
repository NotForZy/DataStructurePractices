package Array;

public class Deduplication {
    public Deduplication() {
        test();
    }

    // return length of new array
    private int deduplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int slow = 0, fast = 1;
        while (fast < arr.length) {
            if (arr[slow] == arr[fast]) {
                fast++;
            } else {
                arr[++slow] = arr[fast++];
                // slow++
                // arr[left] = arr[fast]
                // fast++
            }
        }
        return slow + 1;
    }

    /*
     * keep two elements of each genre ( if has )
     *
     * e.g. : 1 2 2 3 3 3 3 5
     *   out: 1 2 2 3 3 5
     *
     */
    // slow include/exclude/count
    private int deduplicate2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return 1;
        }
        int slow = 1, fast = 2;
        while (fast < arr.length) {
            if (arr[slow - 1] != arr[fast]) {
                arr[++slow] = arr[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    // delete all consecutive duplicate elements
    private int deduplicateDelete(int[] arr) {
        return 0;
    }

    private void test() {
        int[] arr = {1, 2, 2, 3, 3, 3, 5, 5, 5, 5, 6};
        System.out.println("The deduplicate number of array is: " +
                + deduplicate(arr) + " " + deduplicate2(arr));
    }
}
