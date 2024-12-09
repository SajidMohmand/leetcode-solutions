public class Q3152 {

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n]; // Prefix sum array for counting "bad pairs"
        boolean[] special = new boolean[n - 1]; // Store parity info of adjacent elements
        for (int i = 0; i < n - 1; i++) {
            special[i] = (nums[i] % 2 != nums[i + 1] % 2); // true if different parity
            prefix[i + 1] = prefix[i] + (special[i] ? 0 : 1); // Increment if "bad pair"
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            int badPairs = prefix[to] - prefix[from];
            answer[i] = (badPairs == 0); // True if no "bad pairs"
        }

        return answer;
    }
    static void display(boolean[] arr){
        for (boolean i: arr) System.out.print(i+" ");
    }

    public static void main(String[] args) {
//        Input: nums = [3,4,1,2,6], queries = [[0,4]]
//        Output: [false]


        boolean[] x = isArraySpecial(new int[]{3,4,1,2,6},new int[][]{{0,4}});
        display(x);
    }
}
