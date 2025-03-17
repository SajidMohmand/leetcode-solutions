public class Q1718 {

    public static int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1];

        backtrack(result, used, 0, n);
        return result;
    }

    private static boolean backtrack(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) return true;

        if (result[index] != 0) return backtrack(result, used, index + 1, n);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            if (num == 1 || (index + num < result.length && result[index + num] == 0)) {
                result[index] = num;
                if (num > 1) result[index + num] = num;
                used[num] = true;

                if (backtrack(result, used, index + 1, n)) return true;

                result[index] = 0;
                if (num > 1) result[index + num] = 0;
                used[num] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        constructDistancedSequence(3);
    }
}
