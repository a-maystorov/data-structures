import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        var first = queue.dequeue();
        System.out.println(first);
    }
}
