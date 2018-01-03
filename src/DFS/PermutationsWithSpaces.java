package DFS;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string, we can insert at most one empty space between each pair
 * of adjacent letters.
 * Print all permutations of strings after insertions of empty spaces.
 *
 * input: str = "ABC"
 * output:
 *     ABC
 *     AB_C
 *     A_BC
 *     A_B_C
 */


public class PermutationsWithSpaces {
    public PermutationsWithSpaces() {
        test();
    }

    private List<String> permutations(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        helper(sb, charArray, 0, result);
        return result;
    }

    private void helper(StringBuilder sb, char[] str, int pos, List<String> list) {
        if (pos == str.length - 1) {
            sb.append(str[pos]);
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        // not append '_'
        helper(sb.append(str[pos]), str, pos + 1, list);
        sb.deleteCharAt(sb.length() - 1);

        // append  '_'
        helper(sb.append(str[pos]).append('_'), str, pos + 1, list);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    private void test() {
        String str = "ABCD";
        List<String> result = permutations(str);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
