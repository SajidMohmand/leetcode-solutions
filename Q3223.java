public class Q3223 {
    public static int minimumLength(String s) {
        int[] charFrequency = new int[26];

        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        int minLength = 0;

        for (int freq : charFrequency) {
            if (freq > 0) {
                minLength += (freq % 2 == 0) ? 2 : 1;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("sajidkhan"));
    }
}
