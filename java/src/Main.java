public class Main {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(4);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        System.out.println("Before: " + arr); // [1, 2, 3, 4]
        arr.reverseInPlace();
        System.out.println("After: " + arr); // [4, 3, 2, 1]
    }
}
