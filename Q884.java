import java.util.*;
public class Q884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        // Split the two sentences into words
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        // Use a HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        // Add words from str1 to the map and count their frequency
        for (String word : str1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Add words from str2 to the map and count their frequency
        for (String word : str2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Create a list to store the result
        List<String> result = new ArrayList<>();

        // Find words that occur exactly once
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        // Convert the list to an array and return
        return result.toArray(new String[0]);
    }


}
