import java.util.Stack;

public class ValidParentheses {
    private ValidParentheses() {}

    static boolean isValid(final String input) {

        Stack<Character> stack= new Stack<>();

        for (Character character : input.toCharArray()){
            if (character == '(' || character == '[' || character == '{'){
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty()){
                    return false;
                }
                Character lastChar = stack.pop();
                if (character == ')' && lastChar == '(' ||
                    character == ']' && lastChar == '[' ||
                    character == '}' && lastChar == '{' ) {
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("-(1+2)")); // true
        System.out.println(isValid("([]){}")); // true
        System.out.println(isValid("[(])"));  // false
        System.out.println(isValid("[("));  // false
        System.out.println(isValid("}}"));  // false
    }
}
