import java.util.*;
public class Q1671 {
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (left[i] > 1 && right[i] > 1) { // peak element in the mountain
                maxMountainLength = Math.max(maxMountainLength, left[i] + right[i] - 1);
            }
        }
        return maxMountainLength == 0 ? 0 : n - maxMountainLength;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,5,6,2,3,1};
        System.out.println(minimumMountainRemovals(arr));
    }

}
