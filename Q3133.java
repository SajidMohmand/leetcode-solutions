public class Q3133 {
    public static long minEnd(int n, int x) {
        long current = x;
        for (int i = 1; i < n; i++) {
            // Increment current to find the next strictly greater element
            current++;
            // Ensure the AND of all elements remains equal to x
            current |= x;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(minEnd(3,4));
    }
}
