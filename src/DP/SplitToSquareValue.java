package DP;

/*
 * How to cut/split the number into a minimum number of items such that
 * each item is equal to an integer's square value.
 *
 * For example:
 *     4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
 *     Return 1
 *
 *     10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 + 1^2
 *     Return 2
 */


public class SplitToSquareValue {
    public SplitToSquareValue() {
        test();
    }

    /*
     * It's not a greedy problem.
     * Counter case:
     *     42 = 36 + 4 + 1 + 1 (Greedy)
     *     42 = 25 + 16 + 1 (DP)  <= smaller result
     */

    /*
     * Time complexity: O(n * sqrt(n)) = O(n^1.5)
     * Because the inner loop can only last for sqrt(n),
     * constrained by j * j < n.
     *
     * Space complexity: O(n)
     *
     */


    public int smallestSplit(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // Initialization
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }

    private void test() {
        int input = 167;
        int result = smallestSplit(input);
        System.out.println(input + " can be split into " + result + " square numbers as minimum.");
    }
}
