public class Q2257 {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G'; // Guard
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W'; // Wall
        }
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 'G' || grid[i][y] == 'W') break;
                if (grid[i][y] == '\0') grid[i][y] = 'V';
            }
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 'G' || grid[i][y] == 'W') break;
                if (grid[i][y] == '\0') grid[i][y] = 'V';
            }
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 'G' || grid[x][j] == 'W') break;
                if (grid[x][j] == '\0') grid[x][j] = 'V';
            }
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 'G' || grid[x][j] == 'W') break;
                if (grid[x][j] == '\0') grid[x][j] = 'V';
            }
        }
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '\0') {
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
    }

    public static void main(String[] args) {
//        Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//        Output: 7
        int m=4,n=6;
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};

        System.out.println(countUnguarded(m,n,guards,walls));

    }
}
