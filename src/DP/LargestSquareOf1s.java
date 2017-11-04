package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 03/11/2017.
 *
 *
 * Determine the largest square of 1s in a binary matrix
 * (a binary matrix only contains 0 and 1),
 * return the length of the largest square.
 *
 *
 */
public class LargestSquareOf1s {
    public LargestSquareOf1s() {
        test();
    }

    private int largest(int[][] matrix) {
        int[][] helperMatrix = new int[matrix.length][matrix[0].length];
        int globalMax = 0;
        // Initialization
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                helperMatrix[i][0] = 1;
                globalMax = 1;
            } else {
                helperMatrix[i][0] = 0;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                helperMatrix[0][i] = 1;
                globalMax = 1;
            } else {
                helperMatrix[0][i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    helperMatrix[i][j] = 0;
                } else {
                    helperMatrix[i][j] = 1 + Math.min(Math.min(helperMatrix[i - 1][j], helperMatrix[i][j - 1]), helperMatrix[i - 1][j - 1]);
                    if (helperMatrix[i][j] > globalMax) {
                        globalMax = helperMatrix[i][j];
                    }
                }
            }
        }
        return globalMax;
    }

    private void test() {
        int[][] matrix = {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1} };
        int[][] matrix2 = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0}};
        int result = largest(matrix2);
        System.out.println("The length of the largest square is : " + result);
    }
}
