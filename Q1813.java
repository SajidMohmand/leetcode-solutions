public class Q1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0, j = 0;  // two pointers to traverse from the start and end
        int n1 = words1.length, n2 = words2.length;

        // Start comparing from the beginning
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }
//        Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//        Input: sentence1 = "of", sentence2 = "A lot of words"
        // Start comparing from the end
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }

        // The remaining unmatched words should be able to fit between the matched words
        return i + j == Math.min(n1, n2);
    }
}
