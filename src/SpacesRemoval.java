/**
 * project: Test
 *
 * @author YubaiTao on 06/09/2017.
 *
 * Remove all leading/trailing/duplicate empty spaces
 *   (only leave one empty space if duplicated spaces happen) from the input string
 *
 * e.g. :
 *      intput = "___abc__ed__ef__";
 *      output = "abc_ed_ef";
 *
 */
public class SpacesRemoval {
    public SpacesRemoval() {
        test("   abc  ed  ef  ");
    }

    // Two pointers slow & fast move from left to the right hand side all-together
    // (W1)(_W2)(_W3)...(_Wn)
    private String remove(char[] array) {
        int slow = 0;
        int fast = 0;
        int word_count = 0;
        while (true) {
            while (fast < array.length && array[fast] == ' ') {
                fast++;
            }
            if (fast == array.length) {
                break;
            }
            if (word_count > 0) {
                array[slow] = ' ';
                slow++;
            }
            while (fast < array.length && array[fast] != ' ') {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
            word_count++;
        }

        return new String(array, 0, slow);
    }

    private String remove_(String set) {
        if (set.isEmpty()) {
            return set;
        }
        char[] array = set.toCharArray();
        int end = 0;
        // when we would ignore the current space character:
        //     1. we ignore all the space characters followed by
        //     another space character, so that if there are several
        //     consecutive space characters, only the first one will
        //     be remained.
        //     2. we ignore also the space character if it is the
        //     first character of the input string.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end++] = array[i];
        }

        // Post-processing: it is possible we still have one trailing
        // space character at the end.
        if (end > 0 && array[end - 1] == ' ') {
            return new String(array, 0, end - 1);
        }
        return new String(array, 0, end);

    }


    private void test(String set) {
        char[] array = set.toCharArray();
        String result = remove(array);
        String result_ = remove_(set);
        System.out.println("Input:");
        System.out.println(" |" + set);
        System.out.println("Output:");
        System.out.println(" |" + result);
        System.out.println(" |" + result_);
    }
}
