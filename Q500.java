import java.util.ArrayList;
import java.util.List;

public class Q500 {
    public String[] findWords(String[] words) {
        // Create sets for each row of the QWERTY keyboard
        String firstRow = "QWERTYUIOPqwertyuiop";
        String secondRow = "ASDFGHJKLasdfghjkl";
        String thirdRow = "ZXCVBNMzxcvbnm";

        // List to store valid words
        List<String> result = new ArrayList<>();

        // Iterate through each word in the input array
        for (String word : words) {
            if (isInOneRow(word, firstRow) || isInOneRow(word, secondRow) || isInOneRow(word, thirdRow)) {
                result.add(word);  // Add word to result if it's valid
            }
        }

        // Convert result list to an array and return
        return result.toArray(new String[0]);
    }

    private boolean isInOneRow(String word, String row) {
        for (char c : word.toCharArray()) {
            if (row.indexOf(c) == -1) {
                return false;  // Return false if any character is not in the same row
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "sajid ali";

    }

}
