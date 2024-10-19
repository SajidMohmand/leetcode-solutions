public class Q3264 {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0; i<k; i++){
            int a = Integer.MAX_VALUE;
            int index = -1;
            for(int j=0; j<nums.length; j++){
                if (nums[j] < a){
                    a = nums[j];
                    index = j;
                }
            }
            nums[index] = a*multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,3,5,6};
        int[] result= getFinalState(arr,5,2);
        for (int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

    }
}
