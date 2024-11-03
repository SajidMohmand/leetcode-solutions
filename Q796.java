public class Q796 {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubled = s + s;
        return doubled.contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }
}
