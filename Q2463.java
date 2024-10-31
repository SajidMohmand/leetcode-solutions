import java.util.*;
public class Q2463 {
    public static long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, Comparator.comparingInt(a -> a[0]));

        int n = robots.size();
        int m = factories.length;

        long[][] dp = new long[n + 1][m + 1];

        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            int position = factories[j - 1][0];
            int limit = factories[j - 1][1];

            for (int i = 0; i <= n; i++) {
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);

                long distanceSum = 0;

                for (int k = 1; k <= limit && i - k >= 0; k++) {
                    distanceSum += Math.abs((long) robots.get(i - k) - position);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distanceSum);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

//        Input: robot = [0,4,6], factory = [[2,2],[6,2]]
//        Output: 4
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);
        int[][]  factory = {{2,2},{6,2}};
        System.out.println(minimumTotalDistance(robot,factory));
    }
}
