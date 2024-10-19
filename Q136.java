public class Q136 {
    public static int singleNumber(int[] nums) {

        boolean flag = false;
        for (int i=0; i<nums.length; i++){
            flag  = true;
            for (int j = 0; j<nums.length; j++){
                if (i == j) continue;
                if (nums[i] ==nums[j]){
                    flag = false;
                    break;
                }
            }
            if (flag) return nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
}
