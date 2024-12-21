import java.util.List;
import java.util.ArrayList;
public class Q2872 {
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        int[] components = {0};
        dfs(0, -1, tree, values, k, components);
        return components[0];
    }

    private static int dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, int[] components) {
        long subtreeSum = values[node];
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) subtreeSum += dfs(neighbor, node, tree, values, k, components);
        }
        if (subtreeSum % k == 0) {
            components[0]++;
            return 0;
        }
        return (int) (subtreeSum % k);
    }


    public static void main(String[] args) {
//        Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
//        Output: 2

        System.out.println(maxKDivisibleComponents(5,new int[][]{{0,2},{1,2},{1,3},{2,4}},new int[]{1,8,1,4,4},6));
    }
}
