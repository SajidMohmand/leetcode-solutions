public class Q689 {



    // Function to calculate the sum of a subarray starting at index i and of length k
    // Function to calculate the sum of a subarray starting at index i and of length k
    public static int sum(int i, int k, int[] prefixSum) {
        return prefixSum[i + k] - prefixSum[i];
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Calculate the best left subarray for each index
        int[] left = new int[n];
        int maxLeft = 0;
        for (int i = k; i < n; i++) {
            if (sum(i, k, prefixSum) > sum(maxLeft, k, prefixSum)) {
                maxLeft = i;
            }
            left[i] = maxLeft;
        }

        // Calculate the best right subarray for each index
        int[] right = new int[n];
        int maxRight = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum(i, k, prefixSum) >= sum(maxRight, k, prefixSum)) { // >= to handle lexicographically smaller case
                maxRight = i;
            }
            right[i] = maxRight;
        }

        // Find the combination of left, mid, and right subarrays with the maximum sum
        int maxSum = 0;
        int[] result = new int[3];
        // Adjusted the loop condition to ensure the indices do not go out of bounds
        for (int i = k; i <= n - 2 * k; i++) {
            int leftIdx = left[i - 1];
            int rightIdx = right[i + k]; // This line accesses right[i + k] safely
            int currentSum = sum(leftIdx, k, prefixSum) + sum(i, k, prefixSum) + sum(rightIdx, k, prefixSum);
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = leftIdx;
                result[1] = i;
                result[2] = rightIdx;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        Input: nums = [1,2,1,2,6,7,5,1], k = 2
//        Output: [0,3,5]
        int[] a = maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
        for  (int i: a){
            System.out.println(a);
        }
    }
}
