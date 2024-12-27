public class Q1014 {
    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int maxI = values[0];
        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxI + values[j] - j);
            maxI = Math.max(maxI, values[j] + j);
        }
        return maxScore;
    }

    public static void main(String[] args) {
//        Input: values = [8,1,5,2,6]
//        Output: 11

        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
