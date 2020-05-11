package datastructures;

public class LinkedList<T> {

    private int size;
    private Node<T> head;

    /**
     * O(1)
     *
     * without loops
     *
     * @param data
     */
    public void addFront(final T data) {
        //create a new new Node
        final var newNode = new Node<T>(data);

        if (head != null) {
            //Set new new to head then pointer to older head
            newNode.next = this.head;

            //Current head, point to new node
        }
        this.head = newNode;
        increaseSize();
    }

    /**
     * O(n)
     *
     * @param data
     */
    public void addBack(final T data) {
        final var newTail = new Node<T>(data);

        if (head == null){
            head = newTail;
        }else {
            //Set new TAIL
            toTail().next = newTail; // --> O(n)
        }
        increaseSize();
    }

    /**
     * O(1)
     *
     * @return
     */
    public T getFirst() {
        if(this.head == null){
            throw new IllegalStateException("Head is NULL");
        }
        return this.head.data;
    }

    /**
     * O(n)
     *
     * Get last is same as Get Tail
     * @return Tail
     */
    public T getLast() {
        if(this.head == null){
            throw new IllegalStateException("Head is NULL");
        }

        return toTail().data; // --> O(n)
    }

    public int getSize() {
        return size;
    }

    /**
     * O(n)
     *
     * Size by brute force
     * @return
     */
    public int count() {
        if (head == null) {
            return 0;
        }else {
            int count = 1;
            var current = head;

            //while we are not at TAIL
            while (current.next != null) { // --> O(n)
                current = current.next;
                count++;
            }
            return count;
        }
    }

    public void clear() {
        this.size = 0;
        this.head = Node.EMPTY; //let the garbage collector work. Clean all nodes
    }

    /**
     * O(n)
     *
     * @param value
     */
    public void delete(final T value) {
        if (head == null) {
            return;
        }
        var current = head;
        var removed = false;

        if (value.equals(head.data)){
            head = head.next;
            removed = true;
        } else {

            //while we are not at TAIL
            while (current.next != null) { // --> 0(n)
                if (current.next.data.equals(value)) {
                    current.next = current.next.next;
                    removed = true;
                    break;
                }
                current = current.next;
            }
        }
        decreaseSizeIf(removed);
    }

    /**
     * O(n)
     *
     * Start at the Head
     * Walking down to the end
     * @return tail
     */
    private Node<T> toTail() {
        var current = head;

        //while we are not at TAIL
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    private void increaseSize() {
        this.size++;
    }

    private void decreaseSizeIf(final boolean removed) {
        if (removed) {
            this.size--;
        }
    }

    private static class Node<T> {
        private static final Node EMPTY = null;
        private T data;
        private Node<T> next;

        public Node(final T data) {
            this.data = data;
        }
    }
}
