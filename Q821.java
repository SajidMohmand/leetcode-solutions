import java.util.ArrayList;
import java.util.List;

public class Q821 {

    public static int[] shortestToChar(String s, char c) {

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<s.length(); i++){
            int sum = 1;
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(j) == c){
                    list.add(sum);
                    break;
                }
                sum += 1;
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);  // Manual unboxing from Integer to int
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
