import java.util.*;
public class Q338 {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = countBits(2);
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
