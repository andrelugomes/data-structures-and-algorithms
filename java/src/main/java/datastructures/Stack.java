package datastructures;

public class Stack<T> {

    private Stack.Node<T> head; // add and remove here
    private int size;

    /**
     * O(1)
     *
     * @param data
     */
    public void push(final T data) {
        // Create new node
        final var node = new Node(data);

        // Set it's next to be head
        node.next = this.head;

        // Set head to be the new node
        this.head = node;
        size++;
    }

    /**
     * O(1)
     *
     * @return int
     */
    public int getSize() {
        return this.size;
    }

    /**
     * O(1)
     *
     * @return <T>
     */
    public T pop() {
        if(this.head == null){
            throw new IllegalStateException("Head is NULL");
        }

        // Store the value you want to return
        final var result = this.head.getData();

        // Set the current head.next to be the new head
        this.head = this.head.next;
        size--;

        return (T) result;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Node for Stack
     *
     * @param <T>
     */
    private static class Node<T> {
        protected T data;
        protected Node<T> next;

        public Node(final T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
}
