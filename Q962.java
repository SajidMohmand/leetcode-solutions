import java.util.*;

public class Q962 {
    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Build a decreasing stack of indices
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Step 2: Traverse from right to left and calculate the maximum ramp width
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
}
