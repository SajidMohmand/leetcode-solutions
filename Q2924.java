public class Q2924 {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            indegree[v]++;
        }
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (champion != -1) {
                    return -1;
                }
                champion = i;
            }
        }
        return champion;
    }
    public static void main(String[] args) {

    }
}
