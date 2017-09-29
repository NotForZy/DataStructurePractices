/**
 * project: Test
 *
 * @author YubaiTao on 29/09/2017.
 *
 * Evaluate a to the power of b,
 * assuming both a and b are integers and b is non-negative.
 */
public class AtoThePowerOfB {
    public AtoThePowerOfB() {
        test();
    }

    private long power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        long half = power(a, b/2);
        return (b%2 == 0)? half*half : half*half*a;
    }

    private void test() {
        int a, b;
        long result;
        a = 2;
        b = 10;
        result = power(a, b);
        System.out.println("The " + a + " to the power of " + b + " is: " + result);
    }
}
