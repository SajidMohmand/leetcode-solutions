import java.util.*;
public class Q2044 {
    private int computeMaxOr(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        return maxOr;
    }

    // Recursively calculate the number of subsets with the maximum OR value
    private int countSubsetsWithMaxOr(int[] nums, int index, int currentOr, int maxOr) {
        // If we've considered all elements
        if (index == nums.length) {
            // If current OR is equal to max OR, it's a valid subset
            return currentOr == maxOr ? 1 : 0;
        }

        // Include the current element in the OR calculation
        int include = countSubsetsWithMaxOr(nums, index + 1, currentOr | nums[index], maxOr);

        // Exclude the current element from the OR calculation
        int exclude = countSubsetsWithMaxOr(nums, index + 1, currentOr, maxOr);

        // Return the total count of valid subsets from both choices
        return include + exclude;
    }

    // Main method to count the subsets with the maximum possible OR
    public int countMaxOrSubsets(int[] nums) {
        // Find the maximum possible OR value using all elements
        int maxOr = computeMaxOr(nums);

        // Start counting subsets from index 0 with an initial OR value of 0
        return countSubsetsWithMaxOr(nums, 0, 0, maxOr);
    }
}
