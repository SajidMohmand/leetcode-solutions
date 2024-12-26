public class Q494 {


    public static int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }

    private static int backtrack(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = backtrack(nums, target, index + 1, currentSum + nums[index]);

        int subtract = backtrack(nums, target, index + 1, currentSum - nums[index]);

        return add + subtract;
    }

    public static void main(String[] args) {

//        Input: nums = [1,1,1,1,1], target = 3
//        Output: 5
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
