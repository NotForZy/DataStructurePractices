package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * project: Test
 *
 * @author YubaiTao on 20/10/2017.
 *
 *
 *
 * Enhanced version:
 *    () [] {}  different type of parentheses.
 *
 */
public class AllValidPermutationsOfParentheses {
    public AllValidPermutationsOfParentheses() {
        test();
    }


    private List<String> DFS(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, result);
        return result;
    }

    private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
        if (l == n && r == n) {
            result.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            helper(n, l + 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(')');
            helper(n, l, r + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void test() {
        int n = 5;
        List<String> result = DFS(n);
        System.out.println("All valid permutations of parentheses are : ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(" " + result.get(i));
        }
    }
}
