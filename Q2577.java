import java.util.*;

public class Q2577 {
    public static int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // If we cannot move directly to the adjacent cell (1, 0) or (0, 1) initially
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        // Priority Queue to hold states (time, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // Starting at (0, 0) with time 0

        boolean[][] visited = new boolean[m][n];

        // Directions for moving in the grid
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            // If we reach the bottom-right cell, return the time
            if (row == m - 1 && col == n - 1) return time;

            // Mark the cell as visited
            if (visited[row][col]) continue;
            visited[row][col] = true;

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the neighbor is within bounds
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int nextTime = time + 1;

                    // Adjust nextTime to satisfy grid[newRow][newCol]
                    if (nextTime < grid[newRow][newCol]) {
                        // Wait until we can enter the cell
                        nextTime = grid[newRow][newCol];

                        // Ensure we wait for an odd-even parity match
                        if ((nextTime - time) % 2 == 0) {
                            nextTime++;
                        }
                    }

                    // Add the neighbor to the priority queue
                    pq.offer(new int[]{nextTime, newRow, newCol});
                }
            }
        }

        // If we exhaust the queue without reaching the bottom-right, return -1
        return -1;
    }

    public static void main(String[] args) {

//        Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
//        Output: 7

        System.out.println(minimumTime(new int[][]{{0,1,2,3},{5,1,2,5},{4,3,8,6}}));
    }
}
