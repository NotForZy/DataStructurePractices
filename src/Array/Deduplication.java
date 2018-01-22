package Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    // using a counter
    private int deduplicate2_(int[] arr) {
        if (arr == null) {
            return -1;
        }
        if (arr.length <= 1) {
            return arr.length;
        }

        int slow = 0;
        int counter = 1;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] == arr[slow]) {
                if (counter < 2) {
                    arr[++slow] = arr[fast];
                    counter++;
                }
            } else {
                arr[++slow] = arr[fast];
                counter = 1;
            }
        }

        return slow + 1;
    }

    // delete all consecutive duplicate elements
    private int deduplicateDelete(int[] arr) {
        int slow = 0;
        int fast = 0;
        int start;
        while (fast < arr.length) {
            start = fast;
            while (fast < arr.length && arr[fast] == arr[start]) {
                fast++;
            }
            if (fast - start == 1) {
                arr[slow++] = arr[start];
            }
        }
        return slow;
    }


    private int[] deduplication3(int[] arr) {
        // Assumptions: array is not null
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int end = 0;
        // use flag to see if there is any duplicates of array[end].
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[end]) {
                // if there is a duplicate, set flag and do nothing
                flag = true;
            } else if (flag == true) {
                // if array[i] != array[end], and flag is set,
                // array[end] should not be included in the valid subarray,
                // and we can just replace it with array[i] since next
                // we are going to check if there is any duplicate of array[i].
                arr[end] = arr[i];
                // reset flag to false since we are processing another element
                flag = false;
            } else {
                // if arr[i] != arr[end] and flag is not set
                // it means there is no duplicate of arr[end] and it should be
                // included in the valid sub-array.
                arr[++end] = arr[i];
            }
        }
        // do not forget that we need to check if there is any duplicates for
        // the last arr[end]
        return Arrays.copyOf(arr, flag?end:end+1);
    }


    // Use a explicit stack to save the elements.
    // If there are duplicates, pop up.
    private int[] deduplication4(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.offerFirst(array[i]);
                continue;
            }
            if (stack.peekFirst() == array[i]) {
                flag = true;
            } else {
                if (flag == true) {
                    stack.pollFirst();
                    flag = false;
                }
                stack.offerFirst(array[i]);
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i] = stack.pollLast();
            i++;
        }
//        for (int i = 0; i < stack.size(); i++) {
//            result[i] = stack.pollLast();
//        }
        return result;
    }

    private int[] deduplication4_(int[] array) {
        // Assumptions: array is not null.
        int end = -1;
        for (int i = 0; i < array.length; i++) {
            // using the left part of the original arrays as a stack.
            // and the top element's index is end . If the stack is empty(end == -1),
            // we just push the element into the stack, or if the element is not
            // the same as the top element of the stack, we can push the element into
            // the stack as well.
            if (end == -1 || array[end] != array[i]) {
                array[++end] = array[i];
            } else {
                // otherwise, we ignore all consecutive duplicates and
                // remove the top element of the stack
                while (i + 1 < array.length && array[i + 1] == array[end]) {
                    i++;
                }
                end--;
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

    private void test() {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6};
        System.out.println("The deduplicate number of array is: " +
                + deduplicate(arr) + " " + deduplicate2(arr));

        int[] arr3 = {1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6};
        int[] result3 = deduplication3(arr3);
        printArr(result3);

        int[] arr4 = {1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6};
        int[] result4 = deduplication4(arr4);
        printArr(result4);

        int[] arr5 = {1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 4, 6};
        int[] result5 = deduplication4_(arr5);
        printArr(result5);


    }

    private void printArr(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
