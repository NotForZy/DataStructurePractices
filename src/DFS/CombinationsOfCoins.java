package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * project: Test
 *
 * @author YubaiTao on 21/10/2017.
 *
 *
 * Given a number of different denominations of coins
 * (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
 * get all the possible ways to pay a target number of cents.
 *
 *
 * Assumptions:
 *    coins is not null and is not empty, all the number in coins are positive
 *    target >= 0
 *    you have infinite number of coins for each of the denominations,
 *  you can pick any number of the coins
 *
 * Example:
 *     coins = {2, 1}, target = 4, the return should be
 *      [
 *        [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
 *        [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
 *        [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
 *      ]
 *
 *
 */
public class CombinationsOfCoins {
    public CombinationsOfCoins() {
        test();
    }

    // each combination is represented as a List<Integer> cur,
    // and cur.get(i) = the number of coins of coins[i].
    // all the combinations are stored in the result as List of List<Integer>
    private List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(target, coins, 0, cur, result);
        return result;
    }

    // terminate condition:
    // NOTICE: this can also be done at index == coins.length where all the
    // coins have been picked.
    // but a probably better one is at a previous level to reduce the
    // number of unnecessary branches in the DFS
    // coins.length - 1 represents the last coin we
    // can use and actually what we can do at this level is to get
    // target / coins[coins.length - 1] coins if possible
    private void helper(int target, int[] coins, int index, List<Integer> cur,
                        List<List<Integer>> result) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        // for coins[index], we can pick 0, 1, 2, ..., target / coins[index] coins.
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            // remember to modify the remaining cents for the next level.
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    private void test() {
        int[] coins = {2, 1};
        int target = 4;
        List<List<Integer>> result = combinations(target, coins);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(" " + result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
