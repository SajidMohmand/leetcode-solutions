import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Q2206 {

    public static boolean divideArray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i: nums) map.put(i,map.getOrDefault(i,0)+1);

        for (Integer val: map.values()){
            if (val % 2 != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {


        System.out.println(divideArray(new int[]{3,2,3,2,2,2}));
    }
}
