public class Q1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (first == -1) {
                    first = i;  // Store first mismatch index
                } else if (second == -1) {
                    second = i; // Store second mismatch index
                } else {
                    return false; // More than two mismatches → not possible with one swap
                }
            }
        }

        // There must be exactly two mismatches, and swapping them should make the strings equal
        return count == 2 &&
                s1.charAt(first) == s2.charAt(second) &&
                s1.charAt(second) == s2.charAt(first);
    }
}
