public class Q1277 {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        Input: matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//        Output: 15

        int[][] arr = {{0,1,1,1},
        {1,1,1,1},
        {0,1,1,1}};
        System.out.println(countSquares(arr));
    }
}
