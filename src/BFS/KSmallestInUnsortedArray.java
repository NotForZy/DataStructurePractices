package BFS;

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
        return new int[0];
    }

    private void test() {
        int i = 0;
        int[] array = new int[30];
        int[] result;
        while (i < 30) {
            array[i] = (int)(Math.random()*30 + 1);
            i++;
        }
        System.out.println("The original array:");
        for (i = 0; i < 30; i++) {
            System.out.print(" " + array[i]);
        }
        result = kSmallest_I(array, 5);
        System.out.println("\nThe smallest K numbers:");
        for (i = 0; i < 5; i++) {
            System.out.print(" " + result[i]);
        }
    }
}
