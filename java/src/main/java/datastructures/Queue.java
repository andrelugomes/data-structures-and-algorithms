package datastructures;

public class Queue<T> {

    private Queue.Node<T> head; // remove from here
    private Queue.Node<T> tail; // add here
    private int size;

    /**
     * O(1)
     *
     * Add to tail
     *
     * @param value
     */
    public void add(final T value) {

        final var node = new Node<>(value);
        final var currentTail = this.tail;

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

    /**
     * O(1)
     *
     * @return
     */
    public T remove() {
        final var currentHead = this.head;

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
        private T data;
        private Node<T> next;

        public Node(final T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
}
