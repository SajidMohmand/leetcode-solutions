import java.util.PriorityQueue;
public class Q1792 {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0])
        );
        for (int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            double improvement = improvement(pass, total);
            pq.offer(new double[]{improvement, pass, total});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            pq.offer(new double[]{improvement(pass, total), pass, total});
        }
        double totalRatio = 0.0;
        for (double[] cls : pq) {
            int pass = (int) cls[1];
            int total = (int) cls[2];
            totalRatio += (double) pass / total;
        }
        return totalRatio / classes.length;
    }
    private static double improvement(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }

    public static void main(String[] args) {

//        Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//        Output: 0.78333

        System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
    }
}
