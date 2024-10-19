public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the last element in nums1 (ignoring extra spaces)
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last index of nums1 (considering the extra spaces)

        // Merge in reverse order (from the end of both arrays)
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are any remaining elements in nums2, copy them into nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6}; int n = 3;

//        merge(nums1,m,nums2,n);
    }
}
