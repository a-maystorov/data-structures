import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 1, 3, 6, 5 };
        var search = new Search();
        var index = search.linearSearch(numbers, 3);
        System.out.println(index);
    }
}
