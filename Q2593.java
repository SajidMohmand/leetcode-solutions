import java.util.PriorityQueue;

public class Q2593 {
    public static long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[]{nums[i], i});
        }
        long score = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];
            if (marked[index]) {
                continue;
            }
            score += value;
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index < n - 1) {
                marked[index + 1] = true;
            }
        }
        return score;
    }

    public static void main(String[] args) {


        System.out.println(findScore(new int[]{2,1,3,4,5,2}));
    }
}
