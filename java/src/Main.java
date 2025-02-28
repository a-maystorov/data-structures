import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 5, 3, 10, 1, 4, 2 };
        var heap = new Heap();

        for (var number : numbers)
            heap.insert(number);

//        reverse loop direction for ascending order
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = heap.remove();

        System.out.println(Arrays.toString(numbers));
    }
}
