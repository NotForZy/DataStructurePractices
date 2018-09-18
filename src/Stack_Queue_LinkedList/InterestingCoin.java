package Stack_Queue_LinkedList;

/**
 * project: Test
 *
 * @author YubaiTao on 09/04/2018.
 */
public class InterestingCoin {
    public InterestingCoin() {
        test();
    }

    private int findInterestingCoins(char[] input) {
        char prev, cur, next;
        int count = 0;

        if (input.length == 0) {
            return 0;
        }
        if (input.length == 1) {
            return 1;
        }
        if (input.length == 2) {
            if (input[0] == input[1]) {
                return 0;
            } else {
                return 2;
            }
        }
        prev = input[0];
        cur = input[1];

        if (prev != cur) {
            count = 1;
        }

        for (int i = 2; i < input.length; i++) {
            next = input[i];
            if (cur != prev || cur != next) {
                count++;
            }
            prev = cur;
            cur = next;
        }
        if (cur != prev) {
            count++;
        }

        return count;
    }

    private void test() {
        char[] in = new char[3];
        char[] input = {'H', 'T', 'H'};
        char[] input2 = {'H', 'T', 'H', 'T', 'T', 'T', 'H'};
        int result = findInterestingCoins(input2);
        System.out.println(result);
    }
}
