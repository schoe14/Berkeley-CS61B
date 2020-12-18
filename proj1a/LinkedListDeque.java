public class LinkedListDeque<T> {
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

    public void addFirst(T item) {
        Node firstNode = sentinel.next;
        sentinel.next = new Node(item);
        sentinel.next.prev = sentinel;
        sentinel.next.next = firstNode;
        firstNode.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        Node lastNode = sentinel.prev;
        sentinel.prev.next = new Node(item);
        sentinel.prev = sentinel.prev.next;
        sentinel.prev.next = sentinel;
        sentinel.prev.prev = lastNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String itemList = new String();
        Node ptr = sentinel;
        for (int i = 0; i < size; i++) {
            itemList += ptr.next.item + " ";
            ptr = ptr.next;
        }
        System.out.print(itemList + " ");
    }

    public T removeFirst() {
        Node firstNode = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if(size > 0) size--;
        return firstNode.item;
    }

    public T removeLast() {
        Node lastNode = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if(size > 0) size--;
        return lastNode.item;
    }

    public T get(int index) {
        if (index >= size) return null;
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        return null;
    }
}