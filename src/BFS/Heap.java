package BFS;

public class Heap {

    public int size;
    public int[] array;
    public int position;

    public Heap(int size) {
        this.size = size;
        array = new int[size + 1];
        position = 0;
    }

    public void createHeap(int[] inputArray){
        if (inputArray.length > 0) {
            for (int i = 0; i < inputArray.length; i++) {
                insert(inputArray[i]);
            }
        }
    }

    public void insert(int x) {
        if (position == 0) {
            array[position + 1] = x;
            position = 2;
            // position: The next vacant position in array
        } else {
            array[position++] = x;
            percolateUp();
        }
    }

    public int remove() {
        int root = array[1];
        array[1] = array[position - 1];
        array[position - 1] = 0;
        position --;
        percolateDown(1);

        return root;
    }

    public void percolateUp() {
        int pos = position - 1;
        // move the position to the current added node
        while (pos > 0 && array[pos/2] > array[pos]) {
            /*
            int y = array[pos];
            array[pos] = array[pos/2];
            array[pos/2] = y;
            */
            swap(pos, pos/2);
            // element swap;
            pos = pos/2;
            // position move upward
        }

    }

    public void percolateDown(int k) {
        // int a = array[k];
        int smallest = k;
        if (2*k < position && array[smallest] > array[2*k]) {
            smallest = 2*k;
        }
        if (2*k + 1 < position && array[smallest] > array[2*k + 1]) {
            smallest = 2*k + 1;
        }
        if (smallest != k) {
            swap(k, smallest);
            percolateDown(smallest);
        }

    }

    public void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void display() {
        for (int i = 1; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("");
    }

    public void testDriver() {
        int rawArray[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        System.out.println("Original Array:");
        for (int i = 0; i < rawArray.length; i++) {
            System.out.print(" " + rawArray[i]);
        }

    }
}
