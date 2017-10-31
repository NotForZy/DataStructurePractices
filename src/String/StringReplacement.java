package String;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * project: Test
 *
 * @author YubaiTao on 31/10/2017.
 */
public class StringReplacement {
    public StringReplacement() {
        test();
    }

    private String replace(String input, String s, String t) {
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s , t);
        }
        return replaceLonger(array, s, t);

    }

    private String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }

        return new String(input, 0, slow);
    }

    // Notice: we will need a longer array in the case, and if the requirement
    //         is "in place", usually you can assume you are given a long enough
    //         char array already, and the original input string resides
    //         on part of the char aray starting from index 0.
    //         In this solution, we actually allocate a larger array on demand, and the
    //         purpose of the solution is to demonstrate how to do it "in place"
    private String replaceLonger(char[] input, String s, String t) {
        ArrayList<Integer> matches = getAllMatches(input, s);
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = result.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }

    // check if the substring from fromIndex is the same as s.
    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // copy the string t to result at fromIndex
    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }

    // get all the matches of s end positions in input
    private ArrayList<Integer> getAllMatches(char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }


    private void test() {
        String input = "dododo";
        String s = "dod";
        String t = "fuck";
        String result = replace(input, s, t);
        System.out.println("The replaced string result is : " + result);
    }
}
