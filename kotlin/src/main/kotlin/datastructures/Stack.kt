package datastructures

class Stack<T> {
    private var head: SNode<T>? = null
    private var size: Int = 0

    fun size(): Int = size

    fun push(value: T) {
        val node = SNode(value)
        node.next = head

        head = node
        size++
    }

    fun pop(): T {
        var result = head?.data
        result ?: throw IllegalStateException("Head is null")

        head = head?.next
        size--

        return result
    }

}

data class SNode<T>(var data: T, var next: SNode<T>? = null)
