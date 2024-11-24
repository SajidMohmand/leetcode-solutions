public class Q1975 {

    public static long maxMatrixSum(int[][] matrix) {
        long totalSum = 0; // Sum of absolute values of all elements
        int negativeCount = 0; // Count of negative elements
        int minAbsValue = Integer.MAX_VALUE; // Smallest absolute value in the matrix

        // Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); // Add absolute value
                if (value < 0) {
                    negativeCount++; // Count negatives
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value)); // Track smallest absolute value
            }
        }

        // If the count of negatives is odd, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsValue;
        }

        return totalSum;
    }

    public static void main(String[] args) {

//        Input: matrix = [[1,-1],[-1,1]]
//        Output: 4
        System.out.println(maxMatrixSum(new int[][]{{1,-1},{-1,1}}));
    }
}
