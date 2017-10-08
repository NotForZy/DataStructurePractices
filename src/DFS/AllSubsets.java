package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YubaiTao on 04/09/2017.
 * @project Test
 *
 * Given a set of characters represented by a String,
 * return a list containing all subsets of the characters.
 *
 * Assumption:
 *     There are no duplicate characters in the given string.
 *
 */
public class AllSubsets {
    public AllSubsets(String set) {
        test(set);
    }


    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    // at each level, determine the character at the position "index" to be picked or not
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // terminate condition:
        //     when we finishes determining for all the characters pick or not
        //     , we have a complete subset.
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        // 1. not pick the character at index.
        helper(set, sb, index + 1, result);
        // 2. pick the character at index
        helper(set, sb.append(set[index]), index + 1, result);
        // remember to remove the added character when back tracking to the previous level.
        sb.deleteCharAt(sb.length() - 1);
    }

    private void test(String set) {
        System.out.println("All subsets:");
        List<String> result = subSets(set);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(" " + result.get(i));
        }
    }

}
