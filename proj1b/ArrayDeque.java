public class ArrayDeque<T> implements Deque<T> {
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
            if (copiedItems[i] == null) {
                break;
            }
            addLast(copiedItems[i]);
        }
        for (int i = 0; i < start; i++) {
            if (copiedItems[i] == null) {
                break;
            }
            addLast(copiedItems[i]);
        }
    }

    @Override
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

    @Override
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int start = returnFirstIndex();
        for (int i = start; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i]);
            }
        }
        for (int i = 0; i < start; i++) {
            if (items[i] != null) {
                System.out.print(items[i]);
            }
        }
    }

    @Override
    public T removeFirst() {
        double rFactor = (double) size / (double) items.length;
        int start = returnFirstIndex();
        T removed = items[start];
        if (size > 0) {
            items[start] = null;
            nextFirst = start;
            size--;
        }
        if (items.length > 8 && rFactor < 0.25) {
            resize(items.length / 2);
        }
        return removed;
    }

    @Override
    public T removeLast() {
        double rFactor = (double) size / (double) items.length;
        int end = nextLast - 1;
        if (nextLast == 0) {
            end = items.length - 1;
        }
        T removed = items[end];
        if (size > 0) {
            items[end] = null;
            nextLast = end;
            size--;
        }
        if (items.length > 8 && rFactor < 0.25) {
            resize(items.length / 2);
        }
        return removed;
    }

    @Override
    public T get(int index) {
        int start = returnFirstIndex();
        if (index >= size) {
            return null;
        }
        T item = (T) new Object();

        for (int i = start; i < items.length; i++) {
            if (items[i] != null && index >= 0) {
                item = items[i];
                index--;
            } else {
                break;
            }
        }
        for (int i = 0; i < start; i++) {
            if (items[i] != null && index >= 0) {
                item = items[i];
                index--;
            } else {
                break;
            }
        }
        return item;
    }
}
