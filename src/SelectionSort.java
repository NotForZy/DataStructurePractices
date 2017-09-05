/**
 * @author YubaiTao on 30/08/2017.
 * @project Test
 */
public class SelectionSort {
    public int size;
    public  int[] array;
    public SelectionSort(int[] array) {
        this.array = array;
        size = array.length;
    }

    public void sort() {
        int i, j, globalMin;
        for (i = 0; i < size - 1; i++) {
            globalMin = i;
            for (j = i + 1; j < size; j++) {
                if (array[j] < array[globalMin]) {
                    globalMin = j;
                }
            }
            swap(i, globalMin);
        }
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void display() {
        this.sort();
        System.out.println("The Sorted Array(Selection Sort):");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
