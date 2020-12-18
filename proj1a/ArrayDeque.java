public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void resize() {

    }

    public void addFirst(T item) {

    }

    public void addLast(T item) {
        if (nextLast >= size) resize();
        items[nextLast] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
    }

//    public T removeFirst() {
//
//    }
//
//    public T removeLast() {
//
//    }
//
//    public T get(int index) {
//
//    }
}
