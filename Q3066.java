import java.util.PriorityQueue;

public class Q3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // Insert all elements into the min-heap
        for (int num : nums) {
            minHeap.offer((long) num);
        }

        int operations = 0;

        // Merge elements until all are ≥ k
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            long smallest = minHeap.poll();
            long secondSmallest = minHeap.poll();

            long newElement = smallest * 2 + secondSmallest;
            minHeap.offer(newElement);

            operations++;
        }

        return operations;
    }
}
