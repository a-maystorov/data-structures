import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };

        ArrayList<Integer> res = PrintAllDistinctElements.solution(arr);

        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
