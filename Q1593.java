import java.util.*;
public class Q1593 {
    public static int maxUniqueSplit(String s) {
        return maxUnique(s, new HashSet<String>());
    }

    public static int maxUnique(String s, Set<String> set) {

        int max = 0;

        for (int i = 1; i <= s.length(); i++) {

            String tmp = s.substring(0, i);

            if (!set.contains(tmp)) {

                set.add(tmp);

                max = Math.max(max, maxUnique(s.substring(i), set) + 1);

                set.remove(tmp);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxUniqueSplit("sajidakhnsajid"));
    }
}
