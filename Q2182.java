import java.util.PriorityQueue;

public class Q2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26]; // Array to store character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer((char) (i + 'a'));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll(); // Get the largest character
            int count = Math.min(freq[current - 'a'], repeatLimit); // Use up to repeatLimit of this character
            freq[current - 'a'] -= count; // Reduce frequency
            for (int i = 0; i < count; i++) {
                result.append(current);
            }
            if (freq[current - 'a'] > 0) {
                if (maxHeap.isEmpty()) break; // If no other character is available, stop
                char next = maxHeap.poll(); // Get the next largest character
                result.append(next); // Add it to the result
                freq[next - 'a']--; // Reduce its frequency
                if (freq[next - 'a'] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(current);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println((char)(97));
    }
}
