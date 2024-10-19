public class Q806 {
    public static int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2]; // result[0] is the number of lines, result[1] is the last line width
        result[0] = 1; // Start with at least one line
        int sum = 0; // Tracks the current line width

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int charWidth = helper(widths, c); // Get the width of the character
            if (sum + charWidth > 100) { // If adding the character exceeds line width
                result[0] += 1; // Increment the line count
                sum = charWidth; // Start a new line with the current character
            } else {
                sum += charWidth; // Add the character to the current line
            }
        }
        result[1] = sum; // The width of the last line
        return result;
    }

    public static int helper(int[] widths, char c) {
        return widths[c - 'a']; // Simpler mapping to get character width
    }


    public static void main(String[] args) {
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};String s = "abcdefghijklmnopqrstuvwxyz";
        int[] arr = numberOfLines(widths,s);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
