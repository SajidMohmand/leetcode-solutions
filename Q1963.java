public class Q1963 {
    public static int minSwaps(String s) {
        int imbalance = 0;  // To track the imbalance between '[' and ']'
        int swaps = 0;      // To store the number of swaps required

//        "][]["
//        "]]][[["

        // Traverse through the string
        for (char c : s.toCharArray()) {
            // If we encounter '[', we increase the balance
            if (c == '[') {
                imbalance++;
            }
            // If we encounter ']', decrease the balance
            else {
                imbalance--;
            }

            // Whenever the imbalance is negative, it means we have more ']' than '['
            // This indicates that we need to swap to balance it
            if (imbalance < 0) {
                swaps++;     // Increment swap count
                imbalance = 1; // After a swap, we expect the balance to be 1 (from -1 to 1)
            }
        }

        return swaps; // Return the minimum number of swaps needed
    }

    public static void main(String[] args) {

        System.out.println(minSwaps("][]["));
    }
}
