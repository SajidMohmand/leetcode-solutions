public class Q3105 {
    public static int longestMonotonicSubarray(int[] nums) {

        int max = 0;
        int new1 =0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                new1++;
                if(max < new1){
                    max = new1;
                }
            }else{
                new1 = 0;
            }
        }
        max = 0;
        new1 =0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                new1++;
                if(max < new1){
                    max = new1;
                }
            }else{
                new1 = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        System.out.println(longestMonotonicSubarray(new int[]{1,4,3,3,2}));
    }
}
