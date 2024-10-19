import java.util.*;

public class Q1331 {
    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        // Create a copy of the array to sort and rank
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        // Map to store the rank of each element
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Assign rank to each element in the sorted array
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Build the rank transformed array
        int[] rankTransformed = new int[n];
        for (int i = 0; i < n; i++) {
            rankTransformed[i] = rankMap.get(arr[i]);
        }

        return rankTransformed;
    }
}
