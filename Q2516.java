public class Q2516 {
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int count : freq) {
            if (count < k) {
                return -1;
            }
        }

        int n = s.length();
        int[] current = new int[3];
        int maxWindow = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            current[s.charAt(right) - 'a']++;
            while (current[0] > freq[0] - k || current[1] > freq[1] - k || current[2] > freq[2] - k) {
                current[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }

    public static void main(String[] args) {

    }
}
