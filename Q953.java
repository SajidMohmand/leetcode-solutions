public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        // Create a mapping of each character in the custom order to its index
        int[] alienOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alienOrder[order.charAt(i) - 'a'] = i;
        }

        // Compare each word with the next word
        for (int i = 0; i < words.length - 1; i++) {
            if (!isInOrder(words[i], words[i + 1], alienOrder)) {
                return false;  // Return false if any two words are not in order
            }
        }

        return true;  // All words are sorted
    }

    // Helper function to compare two words based on alien order
    private boolean isInOrder(String word1, String word2, int[] alienOrder) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);

        // Compare characters of both words
        for (int i = 0; i < minLen; i++) {
            int char1Pos = alienOrder[word1.charAt(i) - 'a'];
            int char2Pos = alienOrder[word2.charAt(i) - 'a'];

            if (char1Pos < char2Pos) {
                return true;  // word1 comes before word2
            } else if (char1Pos > char2Pos) {
                return false;  // word1 comes after word2
            }
        }

        // If one word is a prefix of the other, the shorter one should come first
        return len1 <= len2;
    }

}
