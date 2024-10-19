public class Q69 {
    public static int mySqrt(int x) {
        if (x < 2) return x; // Return x for 0 and 1

        int left = 2, right = x / 2; // Start binary search
        System.out.println("right : "+right);
        while (left <= right) {
            int mid = left + (right - left) / 2; // To avoid overflow
            long square = (long) mid * mid; // Use long to prevent overflow

            if (square == x) {
                return mid; // Found exact square root
            } else if (square < x) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }
        return right; // Right is the floor of the square root
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(mySqrt(x));

    }
}
