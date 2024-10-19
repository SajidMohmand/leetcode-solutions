import  java.util.*;
public class Q2707 {
    public static int minExtraChar(String s, String[] dictionary) {
        // Convert dictionary array to a HashSet for O(1) lookup
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }

        // Initialize a dp array to store the minimum extra characters for each position
        int[] dp = new int[s.length() + 1];

        // Base case: No characters to process at the end of the string
        dp[s.length()] = 0;

        // Process the string from the end to the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            // By default, assume we don't match any word from the dictionary starting at i
            dp[i] = dp[i + 1] + 1; // Add 1 extra character if nothing matches

            // Check every substring starting from i
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                // If the substring exists in the dictionary, update dp[i]
                if (dictSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        // The answer will be in dp[0], which represents the minimum extra characters
        return dp[0];
    }

    public static void main(String[] args) {

        String s = "sayhelloworld"; String[] dictionary = {"hello","world"};
        System.out.println(minExtraChar(s,dictionary));
    }
}
