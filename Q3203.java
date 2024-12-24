import java.util.*;
public class Q3203 {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = findDiameter(edges1);
        int diameter2 = findDiameter(edges2);

        // Minimum diameter after merging
        return Math.max(diameter1, Math.max(diameter2, (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1));
    }

    private int findDiameter(int[][] edges) {
        int n = edges.length + 1; // Number of nodes
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] farthest = bfs(graph, 0);
        int[] farthestFromFarthest = bfs(graph, farthest[1]);

        return farthestFromFarthest[0];
    }

    private int[] bfs(List<List<Integer>> graph, int start) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // {node, distance}
        visited[start] = true;

        int maxDist = 0;
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = node;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                }
            }
        }

        return new int[]{maxDist, farthestNode};
    }

    public static void main(String[] args) {

    }
}
