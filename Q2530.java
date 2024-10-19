
import java.util.*;
public class Q2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
        }

        long score = 0;

        for (int i = 0; i < k; i++) {
            int maxValue = maxHeap.poll();

            score += maxValue;

            int newValue = (int) Math.ceil(maxValue / 3.0);

            maxHeap.add(newValue);
        }

        return score;
    }

}
