import java.util.ArrayList;
import java.util.List;

public class Q748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        // Step 1: Extract letters from the licensePlate and convert to lowercase
        int[] targetCount = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                targetCount[Character.toLowerCase(c) - 'a']++;
            }
        }

        // Step 2: Find the shortest word that completes the license plate
        String result = null;
        for (String word : words) {
            if (completesWord(targetCount, word)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    // Helper function to check if the word contains all characters in targetCount
    private static boolean completesWord(int[] targetCount, String word) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[Character.toLowerCase(c) - 'a']++;
        }

        // Check if word has all the required characters with at least the required frequency
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < targetCount[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";String[] words = {"step","steps","stripe","stepple"};
        System.out.println(shortestCompletingWord(licensePlate,words));

    }
}
