package String;

/**
 * project: Test
 *
 * @author YubaiTao on 30/10/2017.
 *
 * Determine if a small string is a substring of another large string.
 * Return the index of the first occurrence of the small string in the large string.
 * Return -1 if the small string is not a substring of the large string.
 *
 */
public class FindSubstring {
    public FindSubstring() {
        test();
    }

    private int findSub(String large, String small) {
        if (small.length() == large.length()) {
            return -1;
        }
        if (small == "" && large == "") {
            return 0;
        }
        char[] largeArray = large.toCharArray();
        char[] smallArray = small.toCharArray();

        int i;
        int j = 0;

        for (i = 0; i < largeArray.length - smallArray.length + 1; i++) {
            int k;
            k = i;
            while (j < smallArray.length && smallArray[j] == largeArray[k]) {
                k++;
                j++;
                if (j == smallArray.length || k == largeArray.length) {
                    break;
                }
            }
            if (k - i == smallArray.length) {
                return i;
            }
            j = 0;
        }

        return -1;
    }

    private void test() {
        String large = "abcdefg";
        String small = "cde";
        String large2 = "abbaabbab";
        String small2 = "bbab";
        int result = findSub(large2, small2);
        System.out.println("The sub-string's index is : " + result);
    }
}
