public class Q1957 {
    public static String makeFancyString(String s) {
        StringBuilder fancyString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            int n = fancyString.length();
            if (n >= 2 && fancyString.charAt(n - 1) == currentChar && fancyString.charAt(n - 2) == currentChar) {
                continue;
            }

            fancyString.append(currentChar);
        }

        return fancyString.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
}
