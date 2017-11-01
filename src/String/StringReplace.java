package String;

/**
 * project: Test
 *
 * @author YubaiTao on 30/10/2017.
 */
public class StringReplace {
    public StringReplace() {
        test();
    }

    private String replace(String input, String s, String t) {
        if (t.length() > s.length()) {
            return longReplace(input, s, t);
        } else {
            return shortReplace(input, s ,t);
        }
    }

    private String shortReplace(String input, String s, String t) {
        return "";
    }

    private String longReplace(String input, String s, String t) {
        return "";
    }

    private char[] shiftArray(String input, String s, String t, int matches) {
        return new char[input.length() + Math.abs(s.length() - t.length()) * matches];
    }

    private int findMatches(char[] array, String s) {
        int stride = s.length();
        int counter = 0;
        for (int i = 0; i < array.length - stride + 1; i++) {
            if (match(array, s, i, true)) {
                counter += 1;
                i = i + stride - 1;
            }
        }

        return counter;
    }

    // NO NEED FOR DIRECTION FLAG!!
    // Because there should be only one detect direction,
    // which is form left to right.
    // If we naively use the right to left matches,
    // some cases can be ambiguous.
    //     e.g. :   input="dododo" s="dod" t="fuck"
    //              left -> right scan: fuckodo
    //              right -> left scan: dofucko
    // thus we use left to right scan, this result is discard.
    // Correct result is at "StringReplacement"
    private boolean match(char[] array, String s, int index, boolean leftSideFlag) {
        if (leftSideFlag) {
            if (array.length + 1 - index < s.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (array[index + i] != s.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else {
            if (index < s.length()) {
                return false;
            }
            int stride = s.length();
            for (int i = 0; i < s.length(); i++) {
                if (array[index - i] != s.charAt(stride - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    private void test() {
        String input = "appledogapple";
        String s = "apple";
        String t = "cat";
        String result = replace(input, s, t);
        System.out.println("The replaced result is : " + result);
    }
}
