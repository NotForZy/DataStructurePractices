package Sort;

/**
 * @author YubaiTao on 30/08/2017.
 * @project Test
 */
public class QuickSort {
    public int[] array;
    public int size;

    public QuickSort(int[] array) {
        this.array = array;
        size = array.length;
    }

    public void sort(int left, int right) {
        if (array == null || left >= right) {
            return;
        }
        int pivotPos = partition(left, right);
        sort(left, pivotPos - 1);
        sort(pivotPos + 1, right);
    }

    public int partition(int left, int right) {
        int pivotIndex = randomPivot(left, right);
        int pivotValue = array[pivotIndex];
        swap(pivotIndex, right);
        int i = left, j = right - 1;
        while(i <= j) {
            if (array[i] < pivotValue) {
                i++;
            } else if (array[j] >= pivotValue) {
                j--;
            } else {
                swap(i, j);
                i++;
                j--;
            }
        }
        swap(i, right);

        return i;
    }

    public int randomPivot(int left, int right) {
        return left + (int)(Math.random() * (right - left));
    }

    public void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void display() {
        System.out.println("The Sorted Array(Quick Sort):");
        this.sort(0, size - 1);
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
