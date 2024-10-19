import java.util.*;
import java.util.stream.*;

public class Q386 {
    public static List<Integer> lexicalOrder(int n) {

        List<String> nums = new Stack<>();

        for (int i=1; i<=n; i++){
            nums.add(String.valueOf(i));
        }
        Collections.sort(nums);
        List<Integer> intList = nums.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return intList;
    }

    public static void main(String[] args) {
//        lexicalOrder(13);
        System.out.println(lexicalOrder(13));
    }
}
