public class Q2938 {
    public static long minimumSteps(String s) {
        int n = s.length();
        long blackCount = 0; // To count the number of black balls ('1')
        long swaps = 0; // To store the number of swaps required
        long misplacedBlacks = 0; // To count the number of black balls that are not in their correct position

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                misplacedBlacks++;
            } else {
                swaps += misplacedBlacks;
            }
        }

        return swaps;
    }


    public static void main(String[] args) {
        System.out.println(minimumSteps("0111"));
    }
}
