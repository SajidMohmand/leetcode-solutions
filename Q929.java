import java.util.*;
public class Q929 {
    public int numUniqueEmails(String[] emails) {
        // Create a HashSet to store unique email addresses
        HashSet<String> ans = new HashSet<>();

        // Traverse the given array of emails
        for (String x : emails) {
            // Find the position of '@' in the string
            int pos2 = x.indexOf('@');

            // If '@' exists in the string
            if (pos2 < x.length()) {
                // Extract the local part (before '@') and remove all '.'
                String localPart = x.substring(0, pos2).replace(".", "");

                // Combine local part and domain part (after '@')
                x = localPart + x.substring(pos2);

                // Find the position of the first '+' in the email
                int pos1 = x.indexOf('+');
                pos2 = x.indexOf('@');

                // If '+' exists, remove everything after '+' and before '@'
                if (pos1 > 0 && pos1 < x.length() && pos2 < x.length()) {
                    x = x.substring(0, pos1) + x.substring(pos2);
                }

                // Add the processed email to the set
                ans.add(x);
            }
        }

        // Return the size of the set (number of unique emails)
        return ans.size();
    }

}
