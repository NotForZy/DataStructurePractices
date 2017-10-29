package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YubaiTao on 04/09/2017.
 * @project Test
 *
 * Time complexity: O(n!)
 * Space complexity: O(n!)?
 *
 */
public class AllPermutations {
    public AllPermutations() {
        test();
    }

    private List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    /**
     *
     * @param array char array by separating input string
     * @param index as below
     * @param result result permutations list
     *
     * choose the character to be at the position of "index",
     * all the already chosen positions are (0, index - 1)
     * all the candidate characters can be at position "index"
     * are in the sub-array of (index, array.length - 1)
     *
     */
    private void helper(char[] array, int index, List<String> result) {
        // terminate condition:
        //    only when we have already chosen the characters for all the position,
        //    we can have a complete permutation.
        if (index == array.length) {
            result.add(new String(array));
            return;
        }

        /**
         * e.g:
         *     a bcde
         *       -(swap<a,b>)- b acde
         *       -(swap<a,c>)- c bade
         *       ...
         *       -(swap<a,e>)- e bcda
         */


        // all the possible characters could be placed at index are
        // the characters in the sub-array (index, array.length - 1);
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            // swap back when back track to previous level.
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public void test() {
        List<String> result = permutations("abcde");
        System.out.println("All permutations:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(" " + result.get(i));
        }
    }
}
