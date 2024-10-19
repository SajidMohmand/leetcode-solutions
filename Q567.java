import java.util.*;
public class Q567 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Frequency array for s1 and the current window in s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Populate the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Compare the first window
        if (Arrays.equals(s1Count, s2Count)) return true;

        // Start sliding the window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the new character to the window
            s2Count[s2.charAt(i) - 'a']++;
            // Remove the character left out of the window
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            // Check if the new window matches s1's frequency
            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }
}
