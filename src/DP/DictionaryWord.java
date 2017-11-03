package DP;

import java.util.HashSet;
import java.util.Set;

/**
 * project: Test
 *
 * @author YubaiTao on 03/11/2017.
 *
 *
 * Given a word and a dictionary, determine if it can be composed by
 * concatenating words from the given dictionary.
 *
 *
 * Assumptions:
 *     The given word is not null and is not empty.
 *     The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty.
 *
 *
 *
 */
public class DictionaryWord {
    public DictionaryWord() {
        test();
    }

    private boolean canBreak(String input, String[] dict) {
        boolean[] helperArray  = new boolean[input.length() + 1];
        Set<String> dictSet = toSet(dict);
        helperArray[0] = true;
        for (int i = 1; i < helperArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(input.substring(j, i)) && helperArray[j]) {
                    helperArray[i] = true;
                    break;
                }
            }
        }

        return helperArray[helperArray.length - 1];
    }

    private Set<String> toSet(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }

    private void test() {
        String[] dict = { "bob", "cat", "rob"};
        String word = "robob";
        String word2 = "robcatbob";
        boolean result = canBreak(word2, dict);
        System.out.println((result ?"It can":"It can not")+ " be composed by concatenating words from the given array.");
    }
}
