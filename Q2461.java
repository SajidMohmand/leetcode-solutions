import java.util.*;

public class Q2461 {
    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (uniqueElements.contains(nums[right])) {
                uniqueElements.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            uniqueElements.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                uniqueElements.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}
