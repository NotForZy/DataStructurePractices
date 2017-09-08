import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YubaiTao on 16/08/2017.
 */
public class Test {
    public static void main(String[] args) {
        // System.out.println("This is a simple test");
        /*
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }
        */
        int rawArray[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        // int rawArray[] = {3, 6};

        /*
        System.out.println("Original Array:");
        for (int i = 0; i < rawArray.length; i++) {
            System.out.print(" " + rawArray[i]);
        }
        System.out.println("");
        */
//
//        MaxHeap heap = new MaxHeap(rawArray.length);
//        // Heap heap = new Heap(rawArray.length);
//        System.out.println("Min/Max Heap:");
//        heap.createHeap(rawArray);
//        heap.display();
//        System.out.println("Remove Min/Max:");
//        for (int i = 0; i < rawArray.length; i++) {
//            System.out.print(" " + heap.remove());
//        }

//        InsertSort sort = new InsertSort(rawArray, rawArray.length);
//        sort.display();

//        SelectionSort sort = new SelectionSort(rawArray);
//        sort.display();

//        MergeSort sort = new MergeSort(rawArray);
//        sort.display();

//        QuickSort sort = new QuickSort(rawArray);
//        sort.display();

//        MergeSortPlus sort = new MergeSortPlus(rawArray);
//        sort.display();

//        int[] rainbowTest = {1, 0, 1, -1, 0};
//        RainbowSort sort = new RainbowSort(rainbowTest);

//        Fibonacci f = new Fibonacci(50);

//        QueueBy2Stacks queue = new QueueBy2Stacks();
//        queue.offer(2);
//        queue.offer(5);
//        queue.peek();
//        queue.offer(1);
//        queue.poll();
//        queue.peek();
//        queue.poll();

//        ReverseLinkedList r = new ReverseLinkedList();

//        AllSubsets as = new AllSubsets("abcde");
//        AllPermutations ap = new AllPermutations("abcd");

        SpacesRemoval sr  = new SpacesRemoval();
    }
}

