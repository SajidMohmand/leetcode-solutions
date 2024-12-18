import java.util.*;
public class Q1441 {

    public static List<String> buildArray(int[] target, int n) {

        List<Integer> targets = new ArrayList<>();
        for (int num: target){
            targets.addLast(num);
        }

        List<String> list = new ArrayList<>();

        for (int i=1; i<=n; i++){
            if (targets.isEmpty()){
                break;
            }
            list.addLast("Push");

            if (targets.contains(i)){
                targets.remove((Integer)i);
            }else{
                list.addLast("Pop");
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        Input: target = [1,3], n = 3
//        Output: ["Push","Push","Pop","Push"]

        System.out.println(buildArray(new int[]{1,3},3));
    }
}