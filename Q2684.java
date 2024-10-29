public class Q2684 {
    public static int maxMoves(int[][] grid) {
        int n = grid.length; // Number of rows
        int m = grid[0].length; // Number of columns
        int maxMoves = 0;

        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0, n, m, memo));
        }

        return maxMoves;
    }

    private static int dfs(int[][] grid, int row, int col, int n, int m, int[][] memo) {

        if (col == m - 1) return 0;
        if (memo[row][col] != -1) return memo[row][col];

        int maxSteps = 0;
        int currentValue = grid[row][col];

        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < n && newCol < m && grid[newRow][newCol] > currentValue) {
                maxSteps = Math.max(maxSteps, 1 + dfs(grid, newRow, newCol, n, m, memo));
            }
        }
        memo[row][col] = maxSteps;
        return maxSteps;
    }


    public static void main(String[] args) {
//        [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
        int[][] arr = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println(maxMoves(arr));
    }
}
