public class Q2116 {
    public static boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int balance = 0;
        int openSlots = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                openSlots++; // This can be used as '(' or ')'
            } else if (s.charAt(i) == '(') {
                balance++; // Fixed '('
            } else {
                balance--; // Fixed ')'
            }

            if (balance < 0) {
                if (openSlots > 0) {
                    openSlots--;
                    balance++;
                } else {
                    return false; // Not enough open slots to balance
                }
            }
        }

        balance = 0;
        openSlots = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                openSlots++; // This can be used as '(' or ')'
            } else if (s.charAt(i) == ')') {
                balance++; // Fixed ')'
            } else {
                balance--; // Fixed '('
            }

            if (balance < 0) {
                if (openSlots > 0) {
                    openSlots--;
                    balance++;
                } else {
                    return false; // Not enough open slots to balance
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "))()))", locked1 = "010100";
        System.out.println(canBeValid(s1, locked1));
    }
}
