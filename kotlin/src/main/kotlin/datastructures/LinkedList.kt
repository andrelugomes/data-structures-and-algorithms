package datastructures

class LinkedList<T> {
    private var size: Int = 0
    private var head: Node<T>? = null

    fun isEmpty(): Boolean = size == 0

    fun size(): Int = size

    /**
     * If head is null, add...
     * Else, put new node before head
     */
    fun addFront(data: T) {
        head = Node(data = data, next = head)
        /*if (head == null) {
            head = node
        } else {
            node.next = head
        }*/
        size++
    }

    fun addBack(data: T) {
        val tail = Node(data)

        if (head == null) {
            head = tail
        }else {
            getTail()?.next = tail
        }
        size++
    }

    fun getFirst(): T? = head?.data

    fun getLast(): T? = getTail()?.data

    private fun getTail(): Node<T>? {
        var current = head

        while (current?.next != null) {
            current = current.next
        }

        return current
    }

    fun delete(value: T) {
        if (head == null){
            return
        }

        //start to the Head
        var current = head

        //IF head
        if (head?.data == value){
            head = head?.next
            size--
            return
        }

        //While has next
        while (current?.next != null) {
            if (current.next?.data == value) {
                current.next = current.next?.next
                size--
                break
            }
            current = current.next
        }

    }

}

data class Node<T>(var data: T, var next: Node<T>? = null)
