public class Q942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];

        // Two pointers: low starting at 0, high starting at n
        int low = 0, high = n;

        // Traverse through the string
        for (int i = 0; i < n; i++) {
            // If the character is 'I', assign the current low value and increase low
            if (s.charAt(i) == 'I') {
                perm[i] = low++;
            }
            // If the character is 'D', assign the current high value and decrease high
            else {
                perm[i] = high--;
            }
        }

        // Assign the remaining value to the last position
        perm[n] = low; // at this point, low == high

        return perm;
    }
}
