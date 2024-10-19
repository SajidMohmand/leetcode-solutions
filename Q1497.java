public class Q1497 {

    public static boolean canArrange(int[] arr, int k) {
        // Array to store remainder frequencies
        int[] remainderCount = new int[k];

        // Step 1: Calculate remainder frequencies
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k; // Handle negative remainders
            }
            remainderCount[remainder]++;
        }

        // Step 2: Check if we can form pairs
        // Check remainder 0: must be paired with itself, so count must be even
        if (remainderCount[0] % 2 != 0) {
            return false;
        }

        // Check other remainders: remainder i should pair with remainder k - i
        for (int i = 1; i <= k / 2; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        // If all conditions are satisfied, return true
        return true;
    }


    public static void main(String[] args) {
//        Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5

//        System.out.println(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9},5));
        System.out.println(canArrange(new int[]{1,2,3,4,5,6},10));
    }
}
