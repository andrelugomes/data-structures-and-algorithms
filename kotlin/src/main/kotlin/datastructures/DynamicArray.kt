package datastructures

class DynamicArray<T>(initialCapacity: Int) {
    private var data: Array<Any?>
    private var size: Int = 0
    private var initialCapacity: Int

    //Init over constructor
    init {
        data = arrayOfNulls(initialCapacity)
        this.initialCapacity = initialCapacity
    }

    fun get(index: Int): Any? = data[index]

    fun set(index: Int, value: T) {
        data[index] = value
        size++
    }

    fun insert(index: Int, value: T) {
        // Check size
        if (size == initialCapacity) {
            resize()
        }
        // Copy up | Shift
        for (i in size downTo index) {
            data[i + 1] = data[i]
        }

        // Insert
        data[index] = value
        size++
    }

    fun print() {
        data.forEach { println("data[i] = $it") }
    }

    fun add(value: T) {
        if (size == initialCapacity) {
            resize()
        }
        data[size] = value
        size++
    }

    fun delete(index: Int) {
        // Copy down
        for (i in index until size - 1) data[i] = data[i + 1]

        // Clear if last element in array
        if (index == size) data[index] = null else data[size - 1] = null

        size--
    }

    fun size() = size

    fun isEmpty() = size == 0

    fun contains(value: T): Boolean {
        data.forEach {
            if (it == value) return true
        }
        return false
    }

    private fun resize() {
        val newCapacity = if (initialCapacity == 0) 1 else initialCapacity * 2
        val newData = arrayOfNulls<Any?>(newCapacity)
        if (initialCapacity >= 0) System.arraycopy(data, 0, newData, 0, initialCapacity)
        //manual copy array
        /*for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }*/
        data = newData
        initialCapacity = newCapacity
    }
}