import java.util.NoSuchElementException;

/**
 * A Linked List is like a chain of nodes, where each node points to the next one.
 * Unlike arrays where elements are stored in continuous memory,
 * linked list elements can be scattered in memory but stay connected through references.
 */
public class LinkedList {
    /**
     * A Node is a container that holds:
     * 1. A value (in this case, an integer)
     * 2. A reference to the next node
     * <p>
     * We mark it as private static because:
     * - private: Only the LinkedList class needs to know about this structure
     * - static: Node belongs to the LinkedList class, not to any specific instance
     */
    private static class Node {
        private final int value;    // The actual data stored in the node
        private Node next;          // Reference to the next node (null if it's the last node)

        public Node(int value) {
            this.value = value;
            // next is automatically set to null
        }
    }

    private Node first;
    private Node last;
    private int size;

    // ========== BASIC OPERATIONS ==========

    /**
     * Example: Adding 5 to [1->2->3]:
     * Before: first -> 1 -> 2 -> 3 <- last
     * After:  first -> 5 -> 1 -> 2 -> 3 <- last
     */
    public void addFirst(int value) {
        var node = new Node(value);

        if (isEmpty())
            first = last = node;  // For empty list, new node is both first and last
        else {
            node.next = first;    // Connect new node to current first
            first = node;         // Update first to point to new node
        }
        size++;
    }

    /**
     * Example: Adding 4 to [1->2->3]:
     * Before: first -> 1 -> 2 -> 3 <- last
     * After:  first -> 1 -> 2 -> 3 -> 4 <- last
     */
    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty())
            first = last = node;  // For empty list, new node is both first and last
        else {
            last.next = node;     // Connect current last to new node
            last = node;          // Update last to point to new node
        }
        size++;
    }

    /**
     * Example: Removing first from [1->2->3]:
     * Before: first -> 1 -> 2 -> 3 <- last
     * After:  first -> 2 -> 3 <- last
     */
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;  // If only one node, clear all references
        else {
            var second = first.next;  // Save reference to second node
            first.next = null;        // Disconnect the first node
            first = second;           // Update first to point to second node
        }

        size--;
    }

    /**
     * Example: Removing last from [1->2->3]:
     * Before: first -> 1 -> 2 -> 3 <- last
     * After:  first -> 1 -> 2 <- last
     */
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;  // If only one node, clear all references
        else {
            last = getPrevious(last);  // Find second-to-last node
            assert last != null;
            last.next = null;          // Remove connection to old last node
        }

        size--;
    }

    /**
     * Example: indexOf(2) in [1->2->3] returns 1 (0-based index)
     */
    public int indexOf(int value) {
        var currentNode = first;
        int index = 0;

        while (currentNode != null) {
            if (currentNode.value == value)
                return index;
            currentNode = currentNode.next;
            index++;
        }

        return -1;  // Value not found
    }

    /**
     * Returns true if a value exists in the list
     * This method uses indexOf() to do the actual search
     */
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    /**
     * Finds the kth node from the end using the "two-pointer" technique
     * <p>
     * The trick: Use two pointers (a and b) with k-1 nodes between them.
     * Then move both pointers until b reaches the end.
     * At this point, a will be at the kth node from the end.
     * <p>
     * Steps:
     * 1. Set both pointers to start
     * 2. Move b pointer k-1 nodes ahead
     * 3. Move both pointers until b reaches the end
     * 4. a is now at the target node
     * <p>
     * Example: getKthFromTheEnd(2) in [1->2->3->4]:
     * - Initial: a,b -> 1 -> 2 -> 3 -> 4
     * - After step 2: a -> 1 -> 2 -> 3 -> 4 <- b
     * - After step 3: a -> 3 -> 4 <- b
     * Returns: 3 (2nd from end)
     */
    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        // Move b pointer k-1 nodes ahead
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }

        // Move both pointers until b reaches the end
        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    /**
     * Reverses the list in-place (like reversing the direction of all train cars)
     *
     * The trick: For each node, we need to point it to the previous node instead of the next node
     *
     * Steps:
     * 1. Keep track of previous, current, and next nodes
     * 2. For each node:
     *    - Save next node reference
     *    - Point current node to previous node
     *    - Move previous and current pointers forward
     * 3. Fix first and last pointers
     *
     * Example: Reversing [1->2->3]:
     * Start:  first -> 1 -> 2 -> 3 <- last
     * End:    first -> 3 -> 2 -> 1 <- last
     */
    public void reverse() {
        if (isEmpty()) return;

        var prev = first;
        var curr = first.next;
        while (curr != null) {
            var next = curr.next;     // Remember next node
            curr.next = prev;         // Reverse the pointer
            prev = curr;              // Move prev forward
            curr = next;              // Move curr forward
        }

        last = first;                 // Old first becomes last
        last.next = null;             // Last node should point to null
        first = prev;                 // Last processed node becomes first
    }

    // ========== UTILITY METHODS ==========
    public int[] toArray() {
        int[] array = new int[size];
        var currentNode = first;
        int index = 0;

        while (currentNode != null) {
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }
        return array;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var currentNode = first;

        while (currentNode != null) {
            if (currentNode.next == node)
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}