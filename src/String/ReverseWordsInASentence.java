package String;

/**
 * project: Test
 *
 * @author YubaiTao on 30/10/2017.
 *
 * Reverse the words in a sentence.
 *
 * Assumptions:
 *     Words are seperated by single space.
 *     There are no leading or tailing white spaces.
 *
 */
public class ReverseWordsInASentence {
    public ReverseWordsInASentence() {
        test();
    }

    private String reverseString(String input) {
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ') {
                reverseWord(array, slow, fast - 1);
                slow = fast + 1;
            }
            if (fast == array.length - 1) {
                reverseWord(array, slow, fast);
            }
        }
        reverseWord(array, 0, array.length - 1);

        return new String(array, 0, array.length);
    }

    private void reverseWord(char[] array, int left, int right){
        if (left > right) {
            return;
        }
        swap(array, left, right);
        reverseWord(array, left + 1, right - 1);
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private void test() {
        String input = "I Love Google";
        String output = reverseString(input);
        System.out.println("The reversed string is : " + output);
    }
}
