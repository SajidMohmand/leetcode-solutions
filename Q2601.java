import java.util.*;
public class Q2601 {
    public static boolean primeSubOperation(int[] numbers) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= 1000; ++num) {
            boolean isPrime = true;
            for (int divisor : primes) {
                if (num % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }

        int length = numbers.length;
        for (int index = length - 2; index >= 0; --index) {
            if (numbers[index] < numbers[index + 1]) {
                continue;
            }
            int position = binarySearch(primes, numbers[index] - numbers[index + 1]);
            if (position == primes.size() || primes.get(position) >= numbers[index]) {
                return false;
            }
            numbers[index] -= primes.get(position);
        }
        return true;
    }

    private static int binarySearch(List<Integer> primeList, int value) {
        int left = 0, right = primeList.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (primeList.get(mid) > value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {


        System.out.println(primeSubOperation(new  int[]{4,9,6,10}));
    }
}
