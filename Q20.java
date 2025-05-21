import java.util.Stack;

public class Q20 {


    static boolean helper(char a, char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){

            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{

                if (stack.isEmpty() || !helper(stack.pop(), c)){
                    return  false;
                }
            }
        }

        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
