import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {
    static char solution(String str) {
        Set<Character> set = new HashSet<>();
        var chars = str.toCharArray();

        for (var ch : chars) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
