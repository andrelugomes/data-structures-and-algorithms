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

    public T get(final int index) {
        return (T) data[index];
    }

    public void set(int index, T value) {
        data[index] = value;
        size++;
    }

    public void insert(int index, T value) {
        // Check size
        if (size == initialCapacity) {
            resize();
        }

        // Copy up | Shift
        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        /*for (int j = size; j > index; j--) {
            data[j] = data[j - 1];
        }*/

        // Insert
        data[index] = value;
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
    public void delete(int index) {
        // Copy down
        for (int j = index; j < size - 1; j++) {
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

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        for (int i = 0; i <= size - 1; i++) {
            T currentValue = (T) data[i];
            if (currentValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
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

        //manual copy array
        /*for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }*/

        data = newData;
        initialCapacity = newCapacity;
    }
}
