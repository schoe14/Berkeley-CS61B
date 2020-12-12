/**
 * Array based list.
 *
 * @author Josh Hug
 */

public class AList<Item> {

    private Item[] intArray;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        size = 0;
        intArray = (Item[]) new Object[100];
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(intArray, 0, a, 0, size);
        intArray = a;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Item x) {
        if (size == intArray.length) {
            resize(size + 1);
        }
        intArray[size] = x;
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public Item getLast() {
        return intArray[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Item get(int i) {
        return intArray[i];
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
    public Item removeLast() {
        Item x = getLast();
        size--;
        return x;
    }
}