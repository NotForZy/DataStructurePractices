import java.util.LinkedList;
import java.util.Queue;

import BFS.*;
import BinarySearch.*;
import BinaryTree_BinarySearchTree.*;
import DFS.AllPermutations;
import DFS.AllSubsets;
import DFS.AllValidPermutationsOfParentheses;
import DFS.CombinationsOfCoins;
import DP.*;
import HashTable.CommonNumbersOfTwoSortedArrays;
import HashTable.MissingNumber;
import HashTable.TopKFrequentWords;
import Stack_Queue_LinkedList.*;
import String.RepeatedRemoveAdjacentCharacters;
import String.FindSubstring;
import String.RemoveCertainCharacters;
import String.ReverseWordsInASentence;
import String.StringReplacement;


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
//        int rawArray[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        // int rawArray[] = {3, 6};

        /*
        System.out.println("Original Array:");
        for (int i = 0; i < rawArray.length; i++) {
            System.out.print(" " + rawArray[i]);
        }
        System.out.println("");
        */
//
//        BFS.MaxHeap heap = new BFS.MaxHeap(rawArray.length);
//        // BFS.Heap heap = new BFS.Heap(rawArray.length);
//        System.out.println("Min/Max BFS.Heap:");
//        heap.createHeap(rawArray);
//        heap.display();
//        System.out.println("Remove Min/Max:");
//        for (int i = 0; i < rawArray.length; i++) {
//            System.out.print(" " + heap.remove());
//        }

//        Sort.InsertSort sort = new Sort.InsertSort(rawArray, rawArray.length);
//        sort.display();

//        Sort.SelectionSort sort = new Sort.SelectionSort(rawArray);
//        sort.display();

//        Sort.MergeSort sort = new Sort.MergeSort(rawArray);
//        sort.display();

//        Sort.QuickSort sort = new Sort.QuickSort(rawArray);
//        sort.display();

//        Sort.MergeSortPlus sort = new Sort.MergeSortPlus(rawArray);
//        sort.display();

//        int[] rainbowTest = {1, 0, 1, -1, 0};
//        Sort.RainbowSort sort = new Sort.RainbowSort(rainbowTest);

//        Recursion.Fibonacci f = new Recursion.Fibonacci(50);

//        Stack_Queue_LinkedList.QueueBy2Stacks queue = new Stack_Queue_LinkedList.QueueBy2Stacks();
//        queue.offer(2);
//        queue.offer(5);
//        queue.peek();
//        queue.offer(1);
//        queue.poll();
//        queue.peek();
//        queue.poll();

//        Stack_Queue_LinkedList.ReverseLinkedList r = new Stack_Queue_LinkedList.ReverseLinkedList();

//        DFS.AllSubsets as = new DFS.AllSubsets("abcde");
//        DFS.AllPermutations ap = new DFS.AllPermutations("abcd");

//        String.SpacesRemoval sr  = new String.SpacesRemoval();

//        BinarySearch.BinarySearch bs = new BinarySearch.BinarySearch();
//        Recursion.AtoThePowerOfB a2b = new Recursion.AtoThePowerOfB();
//        BinarySearch.BinarySearch.FirstOccurrence fo = new BinarySearch.BinarySearch.FirstOccurrence();
//        BinarySearch.LastOccurrence lo = new BinarySearch.LastOccurrence();
//        BinarySearch.BinarySearch.ClosestInSortedArray cisa = new BinarySearch.BinarySearch.ClosestInSortedArray();
//        BinarySearch.KClosestInSortedArray kcisa = new BinarySearch.KClosestInSortedArray();
//        BinarySearch.BinarySearch.SearchInUnknownSizeSortedArray siussa = new BinarySearch.BinarySearch.SearchInUnknownSizeSortedArray();
//          SearchInSortedArray sisa = new SearchInSortedArray();
//        Stack_Queue_LinkedList.StackImplementation si = new Stack_Queue_LinkedList.StackImplementation();
//        MergeTwoSortedLinkedLists mtsll = new Stack_Queue_LinkedList.MergeTwoSortedLinkedLists();
//        new MiddleNodeInLinkedList();
//        new ReorderLinkedList();
//        new PartitionLinkedList();
//        new TreeTraversal();
//        new KSmallestInUnsortedArray();
//        new TraverseLayerByLayer();
//        new KthSmallestInSortedMatrix();
//        new IfBinaryTreeIsCompleted();
//        new AllSubsets();
//        new AllValidPermutationsOfParentheses();
//        new CombinationsOfCoins();
//        new TopKFrequentWords();
//        new AllPermutations();
//        new MissingNumber();
//        new LongestAscendingSubArray();
//        new MaxProductOfCuttingRope();
//        new ArrayHopper();
//        new CommonNumbersOfTwoSortedArrays();
//        new RemoveAdjacentRepeatedCharacters();
//        new RepeatedRemoveAdjacentCharacters();
//        new FindSubstring();
//        new RemoveCertainCharacters();
//        new ReverseWordsInASentence();
//        new StringReplacement();
//        new ArrayHopperMinJump();
//        new DictionaryWord();
//        new EditDistance();
//        new LargestSquareOf1s();
//        new LargestSubArraySum();
//        new LongestConsecutive1s();
//        new LongestCrossOf1s();
        new KthElementInTwoSortedArrays();
    }
}
