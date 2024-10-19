public class Q670 {
    public static int maximumSwap(int num) {
        // Convert the number to a character array (like a string)
        char[] numArray = Integer.toString(num).toCharArray();
        int n = numArray.length;

        // Create an array to store the last occurrence of each digit (0-9)
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[numArray[i] - '0'] = i;
        }

        // Traverse the number and find the first digit that can be swapped
        // to make the number larger
        for (int i = 0; i < n; i++) {
            // Check digits greater than the current digit
            for (int d = 9; d > numArray[i] - '0'; d--) {
                // If there's a digit greater than numArray[i] that appears later,
                // perform the swap
                if (last[d] > i) {
                    // Swap the digits
                    char temp = numArray[i];
                    numArray[i] = numArray[last[d]];
                    numArray[last[d]] = temp;

                    // Convert the modified array back to an integer and return it
                    return Integer.parseInt(new String(numArray));
                }
            }
        }

        // If no swap makes it larger, return the original number
        return num;
    }

    public static void main(String[] args) {

        System.out.println(maximumSwap(2237));
    }
}
