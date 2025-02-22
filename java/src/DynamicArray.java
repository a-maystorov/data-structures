import java.util.Arrays;

public class DynamicArray {
    private int[] items;
    private int count;
    private static final int DEFAULT_CAPACITY = 1;

    // Constructor
    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        items = new int[initialCapacity];
        count = 0;
    }

    // Default constructor
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    // Core modification methods
    public void insert(int item) {
        resizeIfNeeded();
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        validateIndexForInsert(index);
        resizeIfNeeded();

        // Shift elements right
        for (int i = count; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = item;
        count++;
    }

    public void removeAt(int index) {
        validateIndexForAccess(index);

        // Shift elements left
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    // Array manipulation methods
    public DynamicArray reverse() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }

        DynamicArray result = new DynamicArray(count);
        for (int i = count - 1; i >= 0; i--) {
            result.insert(items[i]);
        }
        return result;
    }

    public DynamicArray reverseInPlace() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }

        int left = 0;
        int right = count - 1;

        while (left < right) {
            int temp = items[left];
            items[left] = items[right];
            items[right] = temp;

            left++;
            right--;
        }

        return this;
    }

    public DynamicArray intersect(DynamicArray other) {
        if (isEmpty() || other.isEmpty()) {
            throw new IllegalStateException("One or both arrays are empty");
        }

        DynamicArray common = new DynamicArray();
        for (int i = 0; i < count; i++) {
            if (other.indexOf(items[i]) >= 0 && common.indexOf(items[i]) == -1) {
                common.insert(items[i]);
            }
        }
        return common;
    }

    // Query methods
    public int max() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }

        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    // Utility methods
    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return items.length;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    @Override
    public String toString() {
        int[] activeItems = new int[count];
        for (int i = 0; i < count; i++) {
            activeItems[i] = items[i];
        }
        return Arrays.toString(activeItems);
    }

    // Private helper methods
    private void resizeIfNeeded() {
        if (count == items.length) {
            int newCapacity = Math.max(items.length * 2, DEFAULT_CAPACITY);
            int[] newItems = new int[newCapacity];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    private void validateIndexForInsert(int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Index " + index + " is out of bounds");
        }
    }

    private void validateIndexForAccess(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index " + index + " is out of bounds");
        }
    }
}