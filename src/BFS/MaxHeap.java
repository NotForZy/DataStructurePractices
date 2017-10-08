package BFS;

/**
 * @author YubaiTao on 27/08/2017.
 * @project Test
 */
public class MaxHeap {
    public int size;
    public int position;
    public int[] array;

    public MaxHeap(int size) {
        this.size = size;
        position = 0;
        array = new int[size + 1];
    }

    public void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void display() {
        // System.out.println("Max BFS.Heap:");
        for (int i = 1; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("");
    }

    public void createHeap(int[] rawArray) {
        if (rawArray.length > 0) {
            for (int i = 0; i < rawArray.length; i++) {
                insert(rawArray[i]);
            }
        }
    }

    public void insert(int x) {
        if (position == 0) {
            array[position + 1] = x;
            position = 2;
        } else {
            /*
            array[position] = x;
            position++;
            */
            array[position++] = x;
            percolateUp();
        }
    }

    public int remove() {
        int root = array[1];
        array[1] = array[position - 1];

        array[position - 1] = 0;
        position--;
        percolateDown(1);

        return root;
    }

    public void percolateUp() {
        int pos = position - 1;
        while (pos > 1 && array[pos/2] < array[pos]) {
            swap(pos, pos/2);
            pos = pos/2;
        }

    }

    public void percolateDown(int k) {
        int biggest = k;
        if (2*k < position && array[2*k] > array[biggest]) {
            biggest = 2*k;
        }
        if (2*k + 1 < position && array[2*k + 1] > array[biggest]) {
            biggest = 2*k + 1;
        }
        if (biggest != k) {
            swap(biggest, k);
            percolateDown(biggest);
        }
    }
}
