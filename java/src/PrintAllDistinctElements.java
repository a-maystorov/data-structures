import java.util.ArrayList;

public class PrintAllDistinctElements {
    static ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer integer : arr) {
            if (!result.contains(integer))
                result.add(integer);
        }

        return result;
    }
}
