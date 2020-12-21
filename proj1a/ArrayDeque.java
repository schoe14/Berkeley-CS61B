public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length / 2;
        nextLast = (items.length / 2) + 1;
    }

    private int returnFirstIndex() {
        int start = nextFirst + 1;
        if (nextFirst == items.length - 1) {
            start = 0;
        }
        return start;
    }

    private void resize(int capacity) {
        T[] copiedItems = items;
//        int start = nextFirst + 1;
//        if (nextFirst == items.length - 1) {
//            start = 0;
//        }
        T[] newItems = (T[]) new Object[capacity];
        int start = returnFirstIndex();
        items = newItems;
        size = 0;
        nextFirst = items.length / 2;
        nextLast = (items.length / 2) + 1;

        for (int i = start; i < copiedItems.length; i++) {
            if (copiedItems[i] == null) break;
            addLast(copiedItems[i]);
        }
        for (int i = 0; i < start; i++) {
            if (copiedItems[i] == null) break;
            addLast(copiedItems[i]);
        }
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size++;
        nextFirst--;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size++;
        nextLast++;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int start = returnFirstIndex();
        for (int i = start; i < items.length; i++) {
            if (items[i] != null) System.out.print(items[i]);
        }
        for (int i = 0; i < start; i++) {
            if (items[i] != null) System.out.print(items[i]);
        }
    }

    public T removeFirst() {
        double RFACTOR = (double) size / (double) items.length;
        int start = returnFirstIndex();
        T removed = items[start];
        items[start] = null;
        nextFirst = start;
        size--;

        if (items.length > 8 && RFACTOR < 0.25) resize(items.length / 2);

        return removed;
    }

    public T removeLast() {
        double RFACTOR = (double) size / (double) items.length;
        int end = nextLast - 1;
        if (nextLast == 0) end = items.length - 1;
        T removed = items[end];
        items[end] = null;
        nextLast = end;
        size--;

        if (items.length > 8 && RFACTOR < 0.25) resize(items.length / 2);

        return removed;
    }

    public T get(int index) {
        int start = returnFirstIndex();
        if (index >= size) return null;
        T item = (T) new Object();

        for (int i = start; i < items.length; i++) {
            if (items[i] != null && index >= 0) {
                item = items[i];
                index--;
            } else break;
        }
        for (int i = 0; i < start; i++) {
            if (items[i] != null && index >= 0) {
                item = items[i];
                index--;
            } else break;
        }
        return item;
    }

    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque();
        a.addLast("a");
        a.addLast("b");
        a.addFirst("c");
        a.addFirst("d");
        a.addFirst("e");
        a.addFirst("f");
        a.addFirst("g");
        a.addFirst("h");
        a.addFirst("i");
        a.addLast("j");
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.addFirst("hello");
        a.get(0);
        a.removeFirst();
        a.removeLast();
//        a.addLast(5);
//        a.addLast(6);
//        a.addLast(7);
//        a.addLast(8);
//        a.addLast(9);
//        a.printDeque();
    }
}