package String;

/**
 * project: Test
 *
 * @author YubaiTao on 29/10/2017.
 */
public class RemoveAdjacentRepeatedCharacters {
    public RemoveAdjacentRepeatedCharacters() {
        test();
    }

    private String deDup(String input) {
        if (input.equals("")) {
            return "";
        }
        if (input.length() == 1) {
            return input;
        }
        char[] array = input.toCharArray();

        int f = 1, s = 0;
        while (f != array.length) {
            if (array[f] == array[s]) {
                f++;
            } else if (array[f] != array[s]) {
                s++;
                array[s] = array[f];
                f++;
            }
        }

        return new String(array, 0, s + 1);
    }

    private void test() {
        String input = "aaaabbbcc";
        String input2 = "aa";
        String result = deDup(input2);
        System.out.println("The result is : " + result);
    }
}
