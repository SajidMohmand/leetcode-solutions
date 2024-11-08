public class Q1829 {
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxK = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] answer = new int[n];
        int numsXOR = 0;
        for (int num : nums) {
            numsXOR ^= num;
        }
        for (int i = 0; i < n; i++) {
            answer[i] = numsXOR ^ maxK;
            numsXOR ^= nums[n - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {

//        Input: nums = [0,1,2,2,5,7], maximumBit = 3
//        Output: [4,3,6,4,6,7]

        int[] arr = getMaximumXor(new int[]{0,1,2,2,5,7},3);
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }
}
