public class Q1422 {
    public static int maxScore(String s) {
        int totalOnes = 0, maxScore = Integer.MIN_VALUE;

        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        int leftZeros = 0, rightOnes = totalOnes;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public static void main(String[] args) {

        System.out.println(maxScore("011101"));
    }

}
