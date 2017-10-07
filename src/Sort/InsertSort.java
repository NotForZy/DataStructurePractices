package Sort;

/**
 * @author YubaiTao on 29/08/2017.
 * @project Test
 */
public class InsertSort {
    public int size;
    public int[] array;
    public InsertSort(int[] array, int size) {
        this.size = size;
        this.array = array;
    }

    public void sort() {
        int key,i,j;
        for (j = 1; j < size; j++) {
            key = array[j];

            for (i = j - 1; i >= 0 && array[i] > key; i--) {
                swap(i, i + 1);
            }
        }
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void display() {
        this.sort();
        System.out.println("The sorted array(Insertion sort):");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
    }

}
