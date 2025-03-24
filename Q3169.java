import java.util.*;

public class Q3169 {

    public static int countDays(int days, int[][] meetings) {
        boolean[] arr = new boolean[days+1];
        for (int i=0; i<meetings.length; i++){

            for (int j=meetings[i][0]; j<meetings[i][1]; j++){
                arr[j] = false;
            }
        }
        int count = 0;
        for (boolean b: arr){
            if (!b) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
