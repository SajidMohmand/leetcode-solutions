public class Q1910 {

    public static String removeOccurrences(String s, String part) {

        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
