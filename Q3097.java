public class Q3097 {
    public static int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int[][] subarrayOrs = new int[nums.length][2]; // Allocate size based on the length of nums
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            subarrayOrs[count][0] = nums[i];
            subarrayOrs[count++][1] = i;

            int validIndex = 0;
            for (int idx = 0; idx < count; idx++) {
                subarrayOrs[idx][0] |= nums[i];
                if (subarrayOrs[idx][0] >= k) {
                    minLength = Math.min(minLength, i - subarrayOrs[idx][1] + 1);
                }
                if (subarrayOrs[validIndex][0] != subarrayOrs[idx][0]) {
                    subarrayOrs[++validIndex][0] = subarrayOrs[idx][0];
                }
                subarrayOrs[validIndex][1] = subarrayOrs[idx][1];
            }
            count = validIndex + 1;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {

        System.out.println(minimumSubarrayLength(new int[]{1,2,3}, 2));
    }
}
