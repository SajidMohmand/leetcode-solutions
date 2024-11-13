public class Q268 {
    public static int missingNumber(int[] nums){

        int missing = nums.length;
        for (int i=0; i<nums.length; i++){

            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
//        Input: nums = [9,6,4,2,3,5,7,0,1]
//        Output: 8

        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

}
