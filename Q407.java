import java.util.PriorityQueue;
public class Q407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int trappedWater = 0;

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            for (int[] dir : directions) {
                int x = cell.x + dir[0];
                int y = cell.y + dir[1];

                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }

                trappedWater += Math.max(0, cell.height - heightMap[x][y]);

                minHeap.offer(new Cell(x, y, Math.max(heightMap[x][y], cell.height)));
                visited[x][y] = true;
            }
        }

        return trappedWater;
    }

    static class Cell {
        int x, y, height;
        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
