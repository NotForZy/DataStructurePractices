import java.util.ArrayList;
import java.util.List;

/**
 * @author YubaiTao on 04/09/2017.
 * @project Test
 */
public class AllPermutations {
    public AllPermutations() {

    }

    public List<String> permutations(String set) {
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

    }
}
