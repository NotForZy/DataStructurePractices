package HashTable;

import java.util.HashSet;

/**
 * project: Test
 *
 * @author YubaiTao on 28/10/2017.
 */
public class MissingNumber {
    public MissingNumber() {
        test();
    }

    // Method 1: use hash set
    private int missingI(int[] array) {
        int n = array.length + 1;
        HashSet<Integer> set = new HashSet<>();
        for (int number : array) {
            set.add(number);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return n;
    }

    // Method 2: use sum
    private int missingII(int[] array) {
        int n = array.length + 1;
        long targetSum = (n + 0L) * (n + 1) / 2;
        long actualSum = 0L;
        for (int num : array) {
            actualSum += num;
        }

        return (int) (targetSum - actualSum);
    }

    //Method 3: use XOR
    // bit operation. - O(n)
    private int missingIII(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        // xor 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        // after this operation, all the numbers from 1 to n
        // are pair xor'ed except for the missing number.
        // since x ^ x = 0, the remaining number is the result.
        for (int num : array) {
            xor ^= num;
        }

        return xor;
    }

    private void test() {
        int[] array = {2, 1, 4};
        int result = missingI(array);
        int result2 = missingII(array);
        int result3 = missingIII(array);
        System.out.println("The missing number is : " + result + "; " + result2 + "; " + result3 + ";");
    }
}
