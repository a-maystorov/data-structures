public class Main {
    public static void main(String[] args) {
        Array nums = new Array(3);
        nums.insert(10);
        nums.insert(20);
        nums.insert(30);
        nums.insertAt(40, 2);

        Array other = new Array(2);
        other.insert(20);
        other.insert(30);

        nums.print();
    }
}