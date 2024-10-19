import java.util.*;
public class Q179 {

    public static String largestNumber(int[] nums) {
        // Convert int[] to String[] so we can use the same comparison logic
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to compare concatenated strings
        Comparator<String> myCompare = (X, Y) -> (X + Y).compareTo(Y + X);

        // Sort the array using the custom comparator in reverse order
        Arrays.sort(arr, myCompare.reversed());

        // Handle the case where all numbers are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted array
        StringBuilder result = new StringBuilder();
        for (String num : arr) {
            result.append(num);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        largestNumber(new int[]{10,2});
    }
}
