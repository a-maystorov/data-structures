import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        var search = new Search();
        var index = search.exponentialSearch(numbers, 50);
        System.out.println(index);
    }
}
