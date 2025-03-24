
import java.util.*;
public class Q1431 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        List<Boolean> res = new ArrayList<>();

        int first = candies[0];
        int index = 0;
        for (int i=1; i<candies.length; i++){
            if (first > candies[i]){
                first = candies[i];
                index = i;
            }
            res.add(true);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
