package datastructures;

public class LinkedList<T> {

    private int size = 0;
    private Node<T> head;

    public void addFront(final T data) {
        //create a new new Node
        var newNode = new Node<T>(data);

        if (head != null) {
            //Set new new to head then pointer to older head
            newNode.next = this.head;

            //Current head, point to new node
        }
        this.head = newNode;
        increaseSize();
    }

    public void addBack(T data) {
        var newTail = new Node<T>(data);

        if (head == null){
            head = newTail;
        }else {
            //Set new TAIL
            toTail().next = newTail;
        }
        increaseSize();
    }

    public T getFirst() {
        if(this.head == null){
            throw new IllegalStateException("Head is NULL");
        }
        return this.head.data;
    }

    /**
     * Get last is same as Get Tail
     *
     * @return Tail
     */
    public T getLast() {
        if(this.head == null){
            throw new IllegalStateException("Head is NULL");
        }

        return toTail().data;
    }

    public int size() {
        return size;
    }

    /**
     * Size by brute force
     *
     * @return
     */
    public int count() {
        if (head == null) {
            return 0;
        }else {
            int count = 1;
            var current = head;

            //while we are not at TAIL
            while (current.next != null) {
                current = current.next;
                count++;
            }
            return count;
        }
    }

    public void clear() {
        this.size = 0;
        this.head = null; //let the garbage collector work. Clean all nodes
    }

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
            while (current.next != null) {
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
     * Start at the Head
     *
     * Walking down to the end
     *
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
        T data;
        Node<T> next;

        public Node(final T data) {
            this.data = data;
        }
    }
}
