package DFS;

/*
 * Given an array of strings, find if all the strings
 * can be chained to form a circle.
 * Two string s1 and s2 can be chained, iff the last
 * letter of s1 is identical to the first letter of s2.
 * "abc" and "cd" can be chained.
 * "abc" and "dz" can not be chained.
 *
 * Example:
 *     Input: arr[] = {"aaa", "bbb", "baa", "aab"}
 *     Output: True
 *
 */

public class CircleStrings {
    public CircleStrings() {
        test();
    }

    private boolean DFS(String[] strArr, int index) {
        if (index == strArr.length) {
            return strArr[index - 1].charAt(strArr[index - 1].length() - 1) ==
                    strArr[0].charAt(0);
        }

        for (int i = index; i < strArr.length; i++) {
            if (index == 0 || strArr[i].charAt(0) ==
                    strArr[index - 1].charAt(strArr[index - 1].length() - 1)) {
                swap(strArr, index, i);
                if (DFS(strArr, index + 1) == true) {
                    return true;
                }
                swap(strArr, index, i);
            }
        }
        return false;
    }

    private void swap(String[] strArr, int a, int b) {
        String tmp = strArr[a];
        strArr[a] = strArr[b];
        strArr[b] = tmp;
    }

    private void test() {
        String[] strArr = {"aaa", "bbb", "baa", "aab"};
        boolean result = DFS(strArr, 0);
        System.out.println("Strings " + (result?"can":"can not") + " form a circle.");
    }
}
