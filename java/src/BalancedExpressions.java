import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpressions {
    private static final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private static final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    static boolean solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (Character character : input.toCharArray()) {
            if (isLeftBracket(character))
                stack.push(character);

            if (isRightBracket(character)) {
                if (stack.empty())
                    return false;

                var top = stack.pop();
                if (!bracketsMatch(top, character))
                    return false;
            }
        }

        return stack.empty();
    }

    private static boolean isLeftBracket(char character) {
        return leftBrackets.contains(character);
    }

    private static boolean isRightBracket(char character) {
        return rightBrackets.contains(character);
    }

    private static boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
