import java.util.*;
public class Q2290 {
    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n]; // Distance matrix to track minimum obstacles
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE); // Initialize to a large value
        dist[0][0] = 0; // Starting point

        Deque<int[]> deque = new ArrayDeque<>(); // Deque for 0-1 BFS
        deque.add(new int[]{0, 0}); // Start from the top-left corner

        int[] dx = {-1, 1, 0, 0}; // Direction vectors for moving in the grid
        int[] dy = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int x = cell[0], y = cell[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny]; // Calculate cost to move to (nx, ny)

                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;

                        if (grid[nx][ny] == 0) {
                            deque.addFirst(new int[]{nx, ny}); // No obstacle: add to front
                        } else {
                            deque.addLast(new int[]{nx, ny}); // Obstacle: add to back
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1]; // Return minimum obstacles to reach bottom-right
    }

    public static void main(String[] args) {

//        Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
//        Output: 2

        System.out.println(minimumObstacles(new int[][]{{0,1,1},{1,1,0},{1,1,0}}));


    }
}
