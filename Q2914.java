public class Q2914 {
    public static int minChanges(String s) {
        int changes = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        return changes;
    }

    public static void main(String[] args) {

        System.out.println(minChanges("1001"));
    }


}
