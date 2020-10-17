package datastructures

class Queue<T> {
    private var head : QNode<T>? = null
    private var tail: QNode<T>? = null
    private var size: Int = 0

    fun size(): Int = size

    fun add(value: T){
        var node = QNode(value)
        var currentTail = tail

        if (currentTail != null) {
            currentTail.next = node;
        }

        if (head == null) {
            this.head = node;
        }
        tail = node
        size++
    }

    fun remove(): T? {
        /*var currentHead = head

        if (currentHead == null) {
            return null
        }*/
        var currentHead: QNode<T>? = head ?: return null

        head = currentHead?.next

        size--
        return currentHead?.data
    }

}

data class QNode<T>(var data: T, var next: QNode<T>? = null)