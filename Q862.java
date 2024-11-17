import java.util.*;

public class Q862 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {

//        Input: nums = [2,-1,2], k = 3
//        Output: 3

        System.out.println(shortestSubarray(new int[]{2,-1,2}, 3));
    }
}
