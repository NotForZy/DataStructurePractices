package BFS;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * project: Test
 *
 * @author YubaiTao on 08/10/2017.
 *
 *
 * Given a matrix of size N x M.
 * For each row the elements are sorted in ascending order,
 * and for each column the elements are also sorted in ascending order.
 * Find the Kth smallest number in it.
 *
 *
 *
 * Best First Search:
 *     1. Initial State (start node)
 *     2. Node Expansion / Generation Rule
 *     3. Terminate Condition
 *
 */
public class KthSmallestInSortedMatrix {
    public KthSmallestInSortedMatrix() {
        test();
    }

    private int BFS(int[][] matrix, int k) {
        if (matrix == null) {
            return -1;
        }
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

//         PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, (Cell c1, Cell c2) -> c1.value.equals(c2.value) ? 0 : c1.value < c2.value ? -1: 1);
//        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k);
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value.equals(o2.value)) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        // have the root node in the heap
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        int counter = 0;
        boolean[][] visited = new boolean[rowSize][colSize];
        visited[0][0] = true;

        while (counter < k - 1) {
            Cell cell = minHeap.poll();
            counter += 1;
            if (cell.column < colSize - 1) {
                Cell rightSideCell = new Cell(cell.row, cell.column + 1, matrix[cell.row][cell.column + 1]);
                if (!visited[cell.row][cell.column + 1]) {
                    minHeap.offer(rightSideCell);
                    visited[cell.row][cell.column + 1] = true;
                }
            }
            if (cell.row < rowSize - 1) {
                Cell downSideCell = new Cell(cell.row + 1, cell.column, matrix[cell.row + 1][cell.column]);
                if (!visited[cell.row + 1][cell.column]) {
                    minHeap.offer(downSideCell);
                    visited[cell.row + 1][cell.column] = true;
                }
            }
        }
        System.out.println("\nCounter: " + counter);

        return minHeap.peek().value;
    }

    private void test() {
        int[][] matrix = new int[][] {
                {1, 3, 5, 7},
                {2, 4, 8, 9},
                {3, 5, 11, 15},
                {6, 8, 13, 18}};
        int k = 4;
        int result = BFS(matrix, k);
        System.out.println("The " + k + "-th smallest value in the sorted array is : " + result);
    }
}


