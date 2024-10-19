import  java.util.*;
public class Q2937 {
    public static int findMinimumOperations(String s1, String s2, String s3) {
        // Case where all strings are identical, no operations needed
        if (s1.equals(s2) && s2.equals(s3)) {
            return 0;
        }

        // Find the minimum length among the three strings
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        // Calculate the total number of operations needed to reduce all strings to minLength
        int operations = 0;

        // If a string's length is greater than minLength, add the number of removals needed
        if (s1.length() > minLength) {
            operations += s1.length() - minLength;
        }
        if (s2.length() > minLength) {
            operations += s2.length() - minLength;
        }
        if (s3.length() > minLength) {
            operations += s3.length() - minLength;
        }

        // If no operations were performed, return -1 (no length mismatch)
        return operations == 0 ? -1 : operations;
    }

    public static void main(String[] args) {

        String  s1 = "dac", s2 = "bac", s3 = "cac";
//        findMinimumOperations(s1,s2,s3);
        System.out.println(findMinimumOperations(s1,s2,s3));
    }
}
