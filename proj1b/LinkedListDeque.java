public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node() {
        }

        public Node(T value) {
            item = value;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node firstNode = sentinel.next;
        sentinel.next = new Node(item);
        sentinel.next.prev = sentinel;
        sentinel.next.next = firstNode;
        firstNode.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node lastNode = sentinel.prev;
        sentinel.prev.next = new Node(item);
        sentinel.prev = sentinel.prev.next;
        sentinel.prev.next = sentinel;
        sentinel.prev.prev = lastNode;
        size++;
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
        String itemList = new String();
        Node ptr = sentinel;
        for (int i = 0; i < size; i++) {
            itemList += ptr.next.item + " ";
            ptr = ptr.next;
        }
        System.out.print(itemList + " ");
    }

    @Override
    public T removeFirst() {
        Node firstNode = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (size > 0) {
            size--;
        }
        return firstNode.item;
    }

    @Override
    public T removeLast() {
        Node lastNode = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (size > 0) {
            size--;
        }
        return lastNode.item;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private T getRecursiveHelper(Node temp, int index) {
        if (index == 0) {
            return temp.item;
        }
        return getRecursiveHelper(temp.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        Node temp = sentinel.next;
        return getRecursiveHelper(temp, index);
    }
}
