public class Main {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        var list = tree.getNodesAtDistance(2);

        for (var item : list)
            System.out.println(item);
    }
}
