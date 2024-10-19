public class Q70 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 1;  // Number of ways to reach the (n-2)th stair
        int prev1 = 1;  // Number of ways to reach the (n-1)th stair
        int current = 1;  // Number of ways to reach the current stair

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;  // Number of ways to reach the ith stair
            prev2 = prev1;  // Move to the next step
            prev1 = current;  // Update previous step
        }

        return current;
    }


}
