package String;

import java.util.HashSet;
import java.util.Set;

/**
 * project: Test
 *
 * @author YubaiTao on 30/10/2017.
 */
public class RemoveCertainCharacters {
    public RemoveCertainCharacters() {
        test();
    }

    private String remove(String input, String t) {
        if (t.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }

    private Set<Character> buildSet(String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }

    private void test() {
        String input = "abcdefghij";
        String t = "aceg";
        String result = remove(input, t);
        System.out.println("The string that certain characters are removed is :");
        System.out.println(" " + result);
    }
}
