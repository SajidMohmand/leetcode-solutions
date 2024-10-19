public class Q3043 {
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0)
            return -1;

        // Find the minimum length between the two arrays
        int minLength = Math.min(arr1.length, arr2.length);

        int i = 0;
        // Find the common prefix between the two arrays
        while (i < minLength && arr1[i] == arr2[i]) {
            i++;
        }

        // If there's no common prefix
        if (i == 0)
            return -1;

        // Return the length of the common prefix
        return i;
    }

}
