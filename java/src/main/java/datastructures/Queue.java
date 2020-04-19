package datastructures;

public class Queue<T> {

    private Node head; // remove from here
    private Node tail; // add here
    private int size;

    /**
     * Add to tail
     *
     * @param value
     */
    public void add(T value) {

        var node = new Node<>(value);
        var currentTail = this.tail;

        if (currentTail != null) {
            currentTail.next = node;
        }

        if (head == null) {
            this.head = node;
        }
        tail = node;
        size++;
    }

    public int getSize() {
        return this.size;
    }

    public T remove() {
        var currentHead = this.head;

        if (currentHead == null) {
            return null;
        }

        this.head = currentHead.next;

        size--;
        return (T) currentHead.getData();
    }

    /**
     * Node for Queue
     *
     * @param <T>
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(final T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
}
