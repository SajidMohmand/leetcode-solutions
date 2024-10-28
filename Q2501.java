import java.util.*;
public class Q2501 {
    public static int longestSquareStreak(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        Map<Integer, Integer> memo = new HashMap<>();
        int maxLen = -1;

        for (int num : nums) {
            maxLen = Math.max(maxLen, findStreak(num, numSet, memo));
        }

        return maxLen >= 2 ? maxLen : -1;
    }

    private static int findStreak(int num, Set<Integer> numSet, Map<Integer, Integer> memo) {
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        long next = (long) num * num;
        int streak = 1;

        if (next <= Integer.MAX_VALUE && numSet.contains((int) next)) {
            streak = 1 + findStreak((int) next, numSet, memo);
        }

        memo.put(num, streak);
        return streak;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,5,6,7};
        System.out.println(longestSquareStreak(arr));


    }


}
