package String;

/**
 * project: Test
 *
 * @author YubaiTao on 30/10/2017.
 */
public class RepeatedRemoveAdjacentCharacters {
    public RepeatedRemoveAdjacentCharacters() {
        test();
    }


    /*
      using a stack
      in-place method: s denotes the implicit stack top
     */
    private String deDup(String input) {
        if(input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int s = 0, f = 1;
        while (f != array.length) {
            if (s == -1) {
                s = 0;
                array[s] = array[f];
                f++;
            } else if (array[s] != array[f]) {
                array[++s] = array[f++];
            } else if (array[s] == array[f]) {
                if (f + 1 == array.length) {
                    s--;
                    f++;
                } else if (array[f + 1] == array[f]) {
                    f++;
                } else if (array[f + 1] != array[f]) {
                    s--;
                    f++;
                }
            }
        }
        return new String(array, 0, s + 1);
    }

    private void test() {
        String input = "abcccbbad";
        String input2 = "abccddd";
        String input3 = "abbc";
        String result = deDup(input3);
        System.out.println("The result is : " + result);
    }
}
