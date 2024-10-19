import java.util.ArrayList;
import java.util.List;

public class Q440 {

    private static int countSteps(int prefix, int n) {
        long current = prefix;
        long nextPrefix = prefix + 1;
        int steps = 0;

        // Count how many numbers are there between 'prefix' and 'nextPrefix' (both as prefixes)
        while (current <= n) {
            steps += Math.min(n + 1, nextPrefix) - current;
            current *= 10;        // Move to the next level of the tree
            nextPrefix *= 10;     // Move to the next level for the next prefix
        }

        return steps;
    }

    public static int findKthNumber(int n, int k) {
        int current = 1;  // Start with prefix 1
        k--;              // Since we're already at the 1st number

        // Traverse the tree until we find the K-th number
        while (k > 0) {
            int steps = countSteps(current, n);

            if (steps <= k) {
                // Move to the next prefix (like moving from 1 to 2, or from 10 to 11)
                current++;
                k -= steps;
            } else {
                // Move deeper into the current prefix (like moving from 1 to 10, then 100, etc.)
                current *= 10;
                k--;
            }
        }

        return current;
    }

    public static void main(String[] args) {
        int n = 1, k = 1;
        System.out.println(findKthNumber(n,k));

    }
}
