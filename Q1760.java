import java.util.ArrayList;
import java.util.Collections;

public class Q1760 {
    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = getMax(nums);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;
        for (int num : nums) {
            if (num > penalty) {
                operations += (num - 1) / penalty;
                if (operations > maxOperations) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }
    public static void main(String[] args) {
//        Input: nums = [9], maxOperations = 2
//        Output: 3
        System.out.println(minimumSize(new int[]{9},2));
    }
}
