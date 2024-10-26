import java.util.*;
public class Q1408 {
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further; we already found it as a substring
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"mass","as","hero","superhero"};
        System.out.println(stringMatching(arr));

    }
}
