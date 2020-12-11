/**
 * Array based list.
 *
 * @author Josh Hug
 */

public class AList {

    private int[] intArray;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        size = 0;
        intArray = new int[100];
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(intArray, 0, a, 0, size);
        intArray = a;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        if (size == intArray.length) {
            resize(size + 1);
        }
        intArray[size] = x;
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public int getLast() {
        if (size > 0) return intArray[size - 1];
        return 0;
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        if (size >= i) return intArray[i];
        return 0;
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public int removeLast() {
        if (size > 0) {
            int removed = intArray[size - 1];
            intArray[size - 1] = 0;
            size--;
            return removed;
        }
        return 0;
    }
}