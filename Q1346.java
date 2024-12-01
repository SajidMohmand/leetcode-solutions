import java.util.HashSet;

public class Q1346 {
//    public static boolean checkIfExist(int[] arr) {
//
//        for (int i=0; i<arr.length; i++){
//            for (int j=0; j<arr.length; j++){
//                if (i==j) continue;
//                if (arr[i] == 2*arr[j]) return true;
//            }
//        }
//        return false;
//    }
    public static boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(2 * j) || (j%2 == 0 && set.contains(j / 2))) {
                return true;
            }
            set.add(j);
        }
        return false;
    }

    public static void main(String[] args) {
//        Input: arr = [10,2,5,3]
//        Output: true

        System.out.println(checkIfExist(new int[]{10,2,5,3}));
    }
}
