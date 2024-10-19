public class Remove_Element {
    public static int removeElement(int[] nums, int val) {

        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == -1) break;
            if(val == nums[i]){
                count++;
                nums[i] = -1;
                int j=0;
                for (j=i; j<nums.length-1; j++){ // shift array on left side
                    if(nums[j+1] == -1){
                        nums[j] = nums[j+1];
                        break;
                    }
                    nums[j] = nums[j+1];
                }
                --i;
                nums[nums.length-1] = -1;
                reveseArray(i,j,nums);
            }
        }
        display(nums);
        return  count;
    }
    static void reveseArray(int s,int n, int[] arr){
        for (int i = n; i>=s; i--){

        }
    }
    static void display(int[] arr){
        for (int i : arr) System.out.print(i +" ");
        System.out.println();
    }

    public static void main(String[] args) {


        int[] arr={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
    }

}
