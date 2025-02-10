import java.util.Stack;

public class Q3174 {
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    stack.pop();
                    break;
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("cb34"));
    }
}
