package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 04/11/2017.
 *
 *
 * Given a matrix that contains only 1s and 0s,
 * find the largest X shape which contains only 1s,
 * with the same arm lengths and the four arms joining at the central point.
 * Return the arm length of the largest X shape.
 *
 */
public class LargestXof1s {
    public LargestXof1s() {
        test();
    }

    private int largest(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 0) {
            return 0;
        }
        int[][] upperLeft = new int[matrix.length][matrix[0].length];
        int[][] lowerRight = new int[matrix.length][matrix[0].length];
        int[][] upperRight = new int[matrix.length][matrix[0].length];
        int[][] lowerLeft = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            lowerRight[0][i] = matrix[0][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            lowerRight[i][0] = matrix[i][0];
        }
        for (int i = matrix[0].length - 1; i > -1; i--) {
            int k = matrix[0].length - i;
            for (int j = 1; j < k; j++) {
               if (matrix[j][k + j] != 0) {
                   lowerRight[j][k + j] = lowerRight[j - 1][k + j - 1] + 1;
               }
            }
        }
        for (int i = matrix.length - 1; i > 0; i--) {
            int k = matrix.length - i;
            for (int j = 1; j < k; j++) {
                if (matrix[k + j][j] != 0) {
                    lowerRight[k + j][j] = lowerRight[j - 1][k + j - 1] + 1;
                }
            }
        }



        return 0;
    }

    private void test() {
        int[][] matrix = {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        int arm = largest(matrix);
        System.out.println("The largest X of 1s has arm length : " + arm);
    }
}
