package BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * project: Test
 *
 * @author YubaiTao on 08/09/2017.
 */
public class Smallest_k {
    public Smallest_k() {

    }

    private int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Best First Search, need a minheap on the value of each cells.
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value.equals(o2.value)) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        // all the generated cells will be marked true,
        // to avoid being generated more than once.
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        // iterate k-1 rounds, and Best First Search the smallest k-1 cells.
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            // the neighbor cell will be inserted back to the minheap only if
            // 1. it is not out of boundary
            // 2. it has not been generated before
            // Because for each cell it could be generated twice.
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column,
                                       matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][columns] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1,
                                       matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }
}

class Cell {  // implements Comparable<Cell> {
    int row;
    int column;
    Integer value;

    Cell(int row, int column, Integer value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

//    @Override
//    public int compareTo(Cell another) {
//        if (this.value.equals(another.value)) {
//            return 0;
//        }
//        return this.value < another.value ? -1 : 1;
//    }

}
