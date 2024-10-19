import  java.util.*;
public class Q804 {
    // Morse encoding for individual characters
    static String morseEncode(char x) {
        switch (x) {
            case 'a': return ".-";
            case 'b': return "-...";
            case 'c': return "-.-.";
            case 'd': return "-..";
            case 'e': return ".";
            case 'f': return "..-.";
            case 'g': return "--.";
            case 'h': return "....";
            case 'i': return "..";
            case 'j': return ".---";
            case 'k': return "-.-";
            case 'l': return ".-..";
            case 'm': return "--";
            case 'n': return "-.";
            case 'o': return "---";
            case 'p': return ".--.";
            case 'q': return "--.-";
            case 'r': return ".-.";
            case 's': return "...";
            case 't': return "-";
            case 'u': return "..-";
            case 'v': return "...-";
            case 'w': return ".--";
            case 'x': return "-..-";
            case 'y': return "-.--";
            case 'z': return "--..";
            default: return "";  // Handle invalid characters if necessary
        }
    }

    // Method to find unique Morse representations
    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueMorseSet = new HashSet<>();

        // Loop through each word in the array
        for (String word : words) {
            StringBuilder morseWord = new StringBuilder();

            // Convert each character of the word into Morse code
            for (int i = 0; i < word.length(); i++) {
                morseWord.append(morseEncode(word.charAt(i)));
            }

            // Add the Morse code representation of the word to the set
            uniqueMorseSet.add(morseWord.toString());
        }

        // Return the number of unique Morse representations
        return uniqueMorseSet.size();
    }
}
