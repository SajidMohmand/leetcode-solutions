import java.util.*;
public class Q2097 {

    public static int[][] validArrangement(int[][] pairs) {
        // Step 1: Build the graph and calculate in/out degrees
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];

            graph.putIfAbsent(start, new Stack<>());
            graph.get(start).push(end);

            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Step 2: Find the starting node for Eulerian path
        int startNode = pairs[0][0]; // Default start node
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        // Step 3: Perform DFS to find the Eulerian path
        List<int[]> result = new ArrayList<>();
        dfs(graph, startNode, result);

        // Step 4: Convert result list to 2D array
        int[][] arrangedPairs = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arrangedPairs[i] = result.get(result.size() - 1 - i); // Reverse the order
        }
        return arrangedPairs;
    }

    private static void dfs(Map<Integer, Stack<Integer>> graph, int node, List<int[]> result) {
        Stack<Integer> neighbors = graph.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            int nextNode = neighbors.pop();
            dfs(graph, nextNode, result);
            result.add(new int[]{node, nextNode});
        }
    }
    static void display(int[][] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i][0]+" ");
            System.out.println(arr[i][1]);
        }
    }

    public static void main(String[] args) {

//        Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
//        Output: [[11,9],[9,4],[4,5],[5,1]]

        int[][] x = new int[][]{{5,1},{4,5},{11,9},{9,4}};
        int[][] arr = validArrangement(x);
        display(arr);

    }
}
