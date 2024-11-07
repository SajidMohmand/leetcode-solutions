public class Q2275 {
    public static int largestCombination(int[] candidates) {
        int[] bit = new int[32];
        for (int num : candidates) {
            int x = 31;
            while (num > 0) {
                if ((num & 1) == 1) {
                    bit[x]++;
                }
                num = num >> 1;
                x--;
            }
        }
        int max = 0;
        for (int count : bit) {
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {


        System.out.println(largestCombination(new int[]{16,17,71,62,12,24,14}));;
    }
}
