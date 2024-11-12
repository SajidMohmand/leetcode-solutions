import java.util.*;
public class Q2070 {

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int n = items.length;
        for (int i = 1; i < n; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int idx = binarySearch(items, query);
            answer[i] = idx >= 0 ? items[idx][1] : 0;
        }
        return answer;
    }

    private static int binarySearch(int[][] items, int price) {
        int left = 0, right = items.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] <= price) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {

//        Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
//        Output: [2,4,5,5,6,6]
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5},};
        int[] queries = {1,2,3,4,5,6};

        int[] output = maximumBeauty(items,queries);

        for (int item: output){
            System.out.print(item+" ");
        }
        System.out.println();
    }
}
