package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 03/11/2017.
 *
 *
 *
 * Given a matrix that contains only 1s and 0s, find the largest coress contains 1s,
 * with the same arm lengths and the four arms joining at the central point.
 *
 *
 */
public class LongestCrossOf1s {
    public LongestCrossOf1s() {
        test();
    }

    private int largest(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 0) {
            return 0;
        }

        int[][] matrixLeft = new int[matrix.length][matrix[0].length];
        int[][] matrixRight = new int[matrix.length][matrix[0].length];
        int[][] matrixUp = new int[matrix.length][matrix[0].length];
        int[][] matrixDown = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixLeft[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
            for (int j = matrix[0].length - 2; j > -1; j--) {
                if (matrix[i][j] == 0) {
                    matrixLeft[i][j] = 0;
                } else {
                    matrixLeft[i][j] = matrixLeft[i][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            matrixRight[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrixRight[i][j] = 0;
                } else {
                    matrixRight[i][j] = matrixRight[i][j - 1] + 1;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrixUp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
            for (int j = matrix.length - 2; j > -1; j--) {
                if (matrix[j][i] == 0) {
                    matrixUp[j][i] = 0;
                } else {
                    matrixUp[j][i] = matrixUp[j + 1][i] + 1;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrixDown[0][i] = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    matrixDown[j][i] = 0;
                } else {
                    matrixDown[j][i] = matrixDown[j - 1][i] + 1;
                }
            }
        }

        int globalMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    int arm = Math.min(Math.min(matrixLeft[i][j], matrixRight[i][j]), Math.min(matrixUp[i][j], matrixDown[i][j]));
                    if (arm > globalMax) {
                        globalMax = arm;
                    }
                }
            }
        }

//        System.out.println(" " + matrixLeft[2][2]);
//        System.out.println(" " + matrixRight[2][2]);
//        System.out.println(" " + matrixUp[2][2]);
//        System.out.println(" " + matrixDown[2][2]);

        return globalMax;
    }

    private void test() {
        int[][] matrix = {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };    // The largest cross of 1s has arm length 2.
        int[][] matrix2 = {
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0},
                {1, 0, 0, 1, 0, 0}
        };    // The largest cross of 1s has arm length 3.
        int[][] matrix3 = {
                {1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 0, 1, 1, 0}
        };
        int largestArm = largest(matrix3);
        System.out.println("The largest cross of 1s has arm length " + largestArm + ".");
    }
}
