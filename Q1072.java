import java.util.*;

public class Q1072 {
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> patternCount = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder complement = new StringBuilder();
            for (int val : row) {
                pattern.append(val);
                complement.append(1 - val);
            }
            String canonicalPattern = pattern.toString();
            String canonicalComplement = complement.toString();
            patternCount.put(canonicalPattern, patternCount.getOrDefault(canonicalPattern, 0) + 1);
            patternCount.put(canonicalComplement, patternCount.getOrDefault(canonicalComplement, 0) + 1);
        }
        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }

    public static void main(String[] args) {
//        Input: matrix = [[0,1],[1,1]]
//        Output: 1

        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0,1},{1,1}}));

    }
}
