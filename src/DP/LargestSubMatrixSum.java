package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 04/11/2017.
 *
 *
 * Given a matrix that contains integers,
 * find the submatrix with the largest sum.
 * Return the sum of the submatrix.
 *
 *
 */
public class LargestSubMatrixSum {
    public LargestSubMatrixSum() {
        test();
    }

    private int largest(int[][] matrix) {
        return 0;
    }

    private void test() {
        int[][] matrix = {
                {1, -2, -1, 4},
                {1, -1, 1, 1},
                {0, -1, -1, 1},
                {0, 0, 1, 1}
        }; // result should be 7, which in this case is the last two columns' sum.
        int sum = largest(matrix);
        System.out.println("The largest sub-matrix sum is : " + sum);
    }
}
