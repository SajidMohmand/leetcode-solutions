import java.util.*;
public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Iterate through each row
        for (int line = 0; line < numRows; line++) {
            List<Integer> row = new ArrayList<>();

            // Calculate each element in the row using binomial coefficients
            for (int i = 0; i <= line; i++) {
                row.add(binomialCoeff(line, i));
            }

            // Add the row to the list
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }

    // Function to calculate the binomial coefficient
    private int binomialCoeff(int n, int k) {
        int res = 1;

        // Compute nCk using a more efficient approach
        if (k > n - k)
            k = n - k;

        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
}
