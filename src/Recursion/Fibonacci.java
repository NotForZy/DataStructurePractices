package Recursion;

/**
 * @author YubaiTao on 02/09/2017.
 * @project Test
 */
public class Fibonacci {
    public Fibonacci(int k) {
        long result = fibonacciI(k);
        System.out.println("Recursion.Fibonacci " + k + "\'s value:" + result);
    }

    private long fibonacci(int k) {
        if (k == 0 || k == 1) {
            return k;
        } else {
            return fibonacci(k - 2) + fibonacci(k - 1);
        }
    }

    // dynamic programming solution with O(n) space
    private long fibonacciI(int k) {
        if (k <= 0) {
            return 0;
        }
        long[] array = new long[k + 1];
        array[1] = 1;
        for (int i = 2; i <= k; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[k];
    }

    // dynamic programming solution with O(1) space
    private long fibonacciII(int k) {
        long a = 0;
        long b = 1;
        if (k <= 0) {
            return a;
        }
        while (k > 1) {
            long temp = a + b;
            a = b;
            b = temp;
            k--;
        }
        return b;
    }
}
