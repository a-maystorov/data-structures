public class Main {
    public static void main(String[] args) {
        Array nums = new Array(3);
        nums.insert(10);
        nums.insert(20);
        nums.insert(30);
        nums.insert(40);

        Array other = new Array(2);
        other.insert(20);
        other.insert(30);

        System.out.println(nums.intersect(other).toString());
    }
}