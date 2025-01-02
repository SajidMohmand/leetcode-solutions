import java.util.ArrayList;

public class Q2559 {

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];
        String vowels = "aeiou";

        for (int i = 0; i < n; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (vowels.indexOf(start) != -1 && vowels.indexOf(end) != -1) {
                prefix[i] = 1;
            }
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            if (li == 0) {
                result[i] = prefix[ri];
            } else {
                result[i] = prefix[ri] - prefix[li - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {

//        Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]

        int[] s = vowelStrings(new String[]{"aba","bcb","ece","aa","e"},new int[][]{{0,2},{1,4},{1,1}});

        for (int i: s){
            System.out.println(i);
        }

    }
}
