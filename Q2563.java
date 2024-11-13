import java.util.*;
public class Q2563 {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = binarySearchLeft(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = binarySearchRight(nums, i + 1, nums.length - 1, upper - nums[i]);

            if (left <= right) {
                count += (right - left + 1);
            }
        }

        return count;
    }

    private static int binarySearchLeft(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int binarySearchRight(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
//        Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
//        Output: 6


        System.out.println(countFairPairs(new int[]{0,1,7,4,4,5},3,6));
    }


}
