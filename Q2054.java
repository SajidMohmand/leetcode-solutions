import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2054 {
    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length, maxSum = 0;
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], events[i][2]);
        }

        for (int i = 0; i < n; i++) {
            int currentValue = events[i][2];
            int low = i + 1, high = n - 1, compatibleIndex = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events[mid][0] > events[i][1]) {
                    compatibleIndex = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (compatibleIndex != -1) {
                currentValue += maxFromRight[compatibleIndex];
            }

            maxSum = Math.max(maxSum, currentValue);
        }

        return maxSum;
    }

    public static void main(String[] args) {
//        Input: events = [[1,3,2],[4,5,2],[2,4,3]]
//        Output: 4
        maxTwoEvents(new int[][]{{1,3,4},{4,5,2},{2,4,3}});
    }
}
