import java.util.*;

public class Q2981 {

    public int maximumLength(String s) {
        int n = s.length();
        int maxLength = -1;
        for (int len = 1; len <= n; len++) {
            Map<String, Integer> substringCount = new HashMap<>();
            for (int i = 0; i <= n - len; i++) {
                String substring = s.substring(i, i + len);
                if (isSpecial(substring)) {
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                    if (substringCount.get(substring) >= 3) {
                        maxLength = Math.max(maxLength, len);
                    }
                }
            }
        }

        return maxLength;
    }
    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }
}
