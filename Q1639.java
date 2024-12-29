public class Q1639 {
    public static int numWays(String[] words, String target) {
        int mod = 1_000_000_007;
        int m = target.length();
        int n = words[0].length();

        int[][] freq = new int[26][n];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                freq[word.charAt(j) - 'a'][j]++;
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                char targetChar = target.charAt(i - 1);
                int charFreq = freq[targetChar - 'a'][j - 1];
                if (charFreq > 0) {
                    dp[i][j] += (int)((1L * dp[i - 1][j - 1] * charFreq) % mod);
                    dp[i][j] %= mod;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

//        Input: words = ["acca","bbbb","caca"], target = "aba"
//        Output: 6

        System.out.println(numWays(new String[]{"acca","bbbb","caca"}, "aba"));
    }
}
