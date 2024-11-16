import java.util.ArrayList;

public class Q3254 {

    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            int maxElement = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i + j] != nums[i + j - 1] + 1) {
                    isConsecutive = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[i + j]);
            }
            result[index++] = isConsecutive ? maxElement : -1;
        }
        return result;
    }

    public static void display(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3);
        display(arr); // Output: [3, 4, -1, -1, -1]
    }
}
