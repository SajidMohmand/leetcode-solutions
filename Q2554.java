import java.util.*;
public class Q2554 {
    public static int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int count = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i) && sum + i <= maxSum) {
                sum += i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Input: banned = [1,6,5], n = 5, maxSum = 6
//        Output: 2
        System.out.println(maxCount(new int[]{1,6,5},5,6));
    }
}
