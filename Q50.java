public class Q50 {
    public static double myPow(double x, int n) {
        // Handle the case where n is negative
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return power(x, n);
    }

    private static double power(double x, int n) {
        // Base cases
        if (n == 0) return 1;
        if (n == 1) return x;

        // Recursively calculate half power
        double half = power(x, n / 2);

        // If n is even, return half * half
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd, return half * half * x
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }
}