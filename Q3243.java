import java.util.*;

public class Q3243 {
    static int  bfsShortestPath(List<List<Integer>> graph, int end) {
        int[] distance = new int[end+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distance[current] + 1 < distance[neighbor]) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance[end];
    }
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add the default roads
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];


        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            // Add the new road to the graph
            graph.get(u).add(v);

            // Find the shortest path from 0 to n-1
            result[i] = bfsShortestPath(graph, n - 1);
        }

        return result;
    }
    static void display(int[] arr){

        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        Input: n = 5, queries = [[2,4],[0,2],[0,4]]
//
//        Output: [3,2,1]

        int[] arr = shortestDistanceAfterQueries(5,new int[][]{{2,4},{0,2},{0,4}});

        display(arr);
    }
}
