import java.util.*;

public class Q819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ").split("\\s+");

        for (String word : words) {
            if (!bannedSet.contains(word) && word.length() > 0) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentWord;
    }
}
