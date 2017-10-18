package BFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * project: Test
 *
 * @author YubaiTao on 08/10/2017.
 *
 * Find the K smallest numbers in an unsorted integer array A.
 * The returned numbers should be in ascending order.
 *
 */
public class KSmallestInUnsortedArray {
    public KSmallestInUnsortedArray() {
        test();
    }

    // The most naive solution:
    //     maintain a min heap,
    //     and poll k elements.
    //
    // Time complexity: O(n + k*log(n))
    private int[] kSmallest_I(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(array.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    // Another solution:
    //     maintain a k-value max heap,
    //     every time when new element comes,
    //     compare it to the heap top to decide
    //     whether to join the heap or not.
    //
    // Time complexity: O(k + (n-k)*log(k))
    private int[] kSmallest_II(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        int i;
        int[] result = new int[k];
        for (i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }
        for (i = k; i < array.length; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for (i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // Better solution:
    //     quick select
    //
    private int[] kSmallest_III(int[] array, int k) {
        // handle corner case
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        // quickselect to find the kth smallest element.
        // after calling this method, the first k elements in the array are
        // the k smallest ones (but not sorted)
        quickSelect(array, 0, array.length - 1, k - 1);
        // copy out the first k elements and sort them.
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);

        return result;
    }

    private void quickSelect(int[] array, int left, int right, int target) {
        // like quick sort, we need to partition using pivot value.
        int mid = partition(array, left, right);
        // unlike quick sort, we only need to do quickselect on at most one partition.
        // if the pivot is already the kth smallest element, we can directly return.
        if (mid == target) {
            return;
        } else if (target < mid) {
            // only need to recursively call quick select on the left partition
            // if the kth smallest one is in the left partition
            quickSelect(array, left, mid - 1, target);
        } else {
            // only need to recursively call quick select on the right partition
            // if the kth smallest one is in the right partition.
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = randomPivot(left, right);
        int pivot = array[pivotIndex];
        int start = left;
        int end = right - 1;
        swap(array, right, pivotIndex);
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] >= pivot) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, start, right);
        return start;
    }

    private int randomPivot(int left, int right) {
        return (int)(Math.random()*(right - left)) + left;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void test() {
        int i = 0;
        int[] array = new int[30];
        int[] result_I;
        int[] result_II;
        int[] result_III;
        while (i < 30) {
            array[i] = (int)(Math.random()*30 + 1);
            i++;
        }
        System.out.println("The original array:");
        for (i = 0; i < 30; i++) {
            System.out.print(" " + array[i]);
        }
        result_I = kSmallest_I(array, 5);
        System.out.println("\nThe smallest K numbers (min heap):");
        for (i = 0; i < 5; i++) {
            System.out.print(" " + result_I[i]);
        }
        result_II = kSmallest_I(array, 5);
        System.out.println("\nThe smallest K numbers (max heap):");
        for (i = 0; i < 5; i++) {
            System.out.print(" " + result_II[i]);
        }
        result_III = kSmallest_III(array, 5);
        System.out.println("\nThe smallest K numbers (quick select):");
        for (i = 0; i < 5; i++) {
            System.out.print(" " + result_III[i]);
        }
    }
}
