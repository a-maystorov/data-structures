import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.remove(null);
        System.out.println(trie.contains("car"));
        System.out.println(trie.contains("care"));
    }
}
