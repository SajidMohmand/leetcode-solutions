import java.util.HashMap;
public class Q2342 {

    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);

            // If a number with the same digit sum exists, update maxSum
            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, num + map.get(digitSum));
            }

            // Store the maximum number for each digit sum
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), num));
        }
        return maxSum;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18,43,36,13,7}));
    }
}
