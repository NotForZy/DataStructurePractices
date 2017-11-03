package DP;

/**
 * project: Test
 *
 * @author YubaiTao on 03/11/2017.
 *
 *
 * Given two strings of alphanumeric characters, determine the minimum number
 * of Replace, Delete, and Insert operations needed to transform one string to the other
 *
 *
 *
 * DP ; we grow string from the left hand side to the right hand side.
 *
 * M[i][j] represents the minimum number of actions to transform substring
 * (the first i letters of s1 to the first j letter of s2)
 *
 * Case 0: do nothing does not apply here, since s1[0] != s2[0]   ???
 * Case 1: REPLACE
 *         replace c1 with c2 distance(s1r + c1, s2r + c2) = 1 + editDistance(s1r, s2r)
 *         editDistance(i, j) - > 1 + editDistance(i - 1, j - 1)
 * Case 2: DELETE
 *         editDistance(i, j) - > 1 + editDistance(i - 1, j)
 * Case 3: INSERT
 *         editDistance(i, j) - > 1 + editDistance(i, j - 1)
 *
 *
 * Base case:
 *     M[0][0] = 0; M[0][j] = j; M[i][0] = i;
 * Induction rule:
 *     M[i][j] =
 *         1. If the i-th letter of s1 == the j-th letter of s2:
 *             case 0:(do nothing) M[i-1][j-1]
 *         2. else
 *             case 1:(replace)    M[i - 1][j - 1] + 1
 *             case 2:(delete)     M[i - 1][j] + 1
 *             case 3:(insert)     M[i][j - 1]
 *
 */
public class EditDistance {
    public EditDistance() {
        test();
    }

    // all operations are done on string one
    // index are corresponding to the i-th element of the string
    private int editDistance(String one, String two) {
        char[] arrayOne = one.toCharArray();
        char[] arrayTwo = two.toCharArray();
        int[][] matrix = new int[one.length() + 1][two.length() + 1];
        // Initialization
        for (int i = 0; i < two.length() + 1; i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i < one.length() + 1; i++) {
            matrix[i][0] = i;
        }
        // Build DP table
        for (int i = 1; i < one.length() + 1; i++) {
            for (int j = 1; j < two.length() + 1; j++) {
                // no operations needed or one operation
                if (arrayOne[i - 1] == arrayTwo[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                }

            }
        }

        return matrix[one.length()][two.length()];
    }

    private void test() {
        String one = "abcdef";
        String two = "bbccf";
        // between above two string, the edit distance is 2
        // one insert"a" at front then replace "g" with "t".
        int result = editDistance(one, two);
        System.out.println("The edit distance is : " + result);
    }
}
