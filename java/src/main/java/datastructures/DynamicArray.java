package datastructures;

/**
 * package java.util.ArrayList equivalent
 * @param <T>
 */
public class DynamicArray<T> {

    private Object[] data;
    private int size = 0;
    private int initialCapacity;

    public DynamicArray(final int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.initialCapacity = initialCapacity;
    }

    /**
     * O(1)
     *
     *
     * @param index
     * @return
     */
    public T get(final int index) {
        return (T) data[index];
    }

    /**
     * O(1)
     *
     *
     * @param index
     * @param value
     */
    public void set(int index, T value) {
        data[index] = value;
        size++;
    }

    /**
     * O(n)
     *
     *
     * @param index
     * @param value
     */
    public void insert(int index, T value) {
        // Check size
        if (size == initialCapacity) {
            resize(); // --> O(n)
        }

        // Manual Array Copy | Shift
        for (int j = size; j > index; j--) {  //--> O(n)
            data[j] = data[j - 1];
        }
        //if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);

        // Insert
        data[index] = value;  //--> O(1)
        size++;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("data[i] = " + data[i]);
        }
    }

    // Some array implementations offer methods like insert (also known as pushBack).
    // Which is like insert, only in does the insert at the end of the array.(append)
    public void add(T value) {
        if (size == initialCapacity) {
            resize();
        }

        data[size] = value;
        size++;
    }

    /**
     * O(n)
     *
     *
     * @param index
     */
    public void delete(int index) {
        // Copy down
        for (int j = index; j < size - 1; j++) { // --> O(n)
            data[j] = data[j + 1];
        }

        // Clear if last element in array
        if (index == size) {
            data[index] = null;
        }else {
            //Clear last value index
            data[size - 1] = null;
        }
        size--;
    }

    /**
     * O(1)
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 0(n)
     *
     * @param value
     * @return
     */
    public boolean contains(T value) {
        for (int i = 0; i <= size - 1; i++) { // --> 0(n)
            T currentValue = (T) data[i];
            if (currentValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(n) : For loop array copy
     *
     * System.arraycopy
     *
     * http://hg.openjdk.java.net/jdk/jdk11/file/1ddf9a99e4ad/src/hotspot/share/prims/jvm.cpp
     *
     * http://hg.openjdk.java.net/jdk7/jdk7/hotspot/file/9b0ca45cd756/src/share/vm/oops/objArrayKlass.cpp#l168
     */
    private void resize() {
        var newCapacity = initialCapacity * 2;
        var newData = new Object[newCapacity];

        if (initialCapacity >= 0) System.arraycopy(data, 0, newData, 0, initialCapacity);

        //manual array copy
        /*for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }*/

        data = newData;
        initialCapacity = newCapacity;
    }
}
