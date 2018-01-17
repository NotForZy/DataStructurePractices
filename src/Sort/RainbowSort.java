package Sort;

/**
 * @author YubaiTao on 02/09/2017.
 * @project Test
 *
 * {0} is sorted to {0}
 * {1, 0} is sorted to {0, 1}
 * {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
 *
 * Time complexity: O(n); total swap number
 * Space complexity: O(3)
 *
 */
public class RainbowSort {
    public RainbowSort(int[] array) {
        sort(array);
        display(array);
    }

    public void sort(int[] array) {
        int i = 0, j = 0, k = array.length - 1;
        while(j <= k) {
            if (array[j] == -1) {
                swap(array, i, j);
                i++;
                j++;
            } else if (array[j] == 0) {
                j++;
            } else { // array[i] == 1
                swap(array, j, k);
                k--;
            }
        }
    }

    public void swap(int[] array, int a, int b) {
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void display(int[] array) {
        System.out.println("The Sorted Array(Rainbow Sort):");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
