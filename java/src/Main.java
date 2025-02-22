import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.reverse();
        var arr = list.toArray();
        System.out.println(Arrays.toString(arr));
    }
}
