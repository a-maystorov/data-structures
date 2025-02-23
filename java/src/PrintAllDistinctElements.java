import java.util.ArrayList;

/**
 * Given an integer array arr[], print all distinct elements from this array.
 * The given array may contain duplicates, and the output should contain each
 * element only once, maintaining its first occurrence order.
 *
 * Examples:
 *
 * Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
 * Output: {12, 10, 9, 45, 2}
 *
 * Input: arr[] = {1, 2, 3, 4, 5}
 * Output: {1, 2, 3, 4, 5}
 *
 * Input: arr[] = {1, 1, 1, 1, 1}
 * Output: {1}
 */

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
