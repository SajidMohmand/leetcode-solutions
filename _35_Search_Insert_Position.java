public class _35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {

        if(nums.length==1){
            if(nums[0] < target){
                return 1;
            }else{
                return 0;
            }
        }
        if(nums[nums.length/2] > target){
            for (int i=0; i<=nums.length/2; i++){
                if (nums[i]==target ||  nums[i]>target){
                    return i;
                }
            }
        }else{
            for (int i=nums.length/2; i<nums.length; i++){
                if (nums[i]==target ||  nums[i]>target){
                    return i;
                }
            }
        }
        return nums.length-1;
    }
}
