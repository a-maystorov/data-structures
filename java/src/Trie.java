public class Trie {
    private static class Node {
        public static int ALPHABET_SIZE = 26;
        private final char value;
        private final Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch: word.toCharArray()) {
            var index = ch - 'a';
            if (current.children[index] == null)
                current.children[index] = new Node(ch);
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
}
