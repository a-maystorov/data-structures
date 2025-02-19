public class Main {
    public static void main(String[] args) {
        Array nums = new Array(3);
        nums.insert(10);
        nums.insert(20);
        nums.insert(30);
        nums.insert(40);
        nums.removeAt(0);
        System.out.println(nums.indexOf(30));
        nums.print();
    }
}