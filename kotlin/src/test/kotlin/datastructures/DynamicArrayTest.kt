package datastructures

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class DynamicArrayTest {

    @Test
    fun `Should Set Value Then Get By Index`() {
        val array = DynamicArray<String>(3)

        assertThat(array.isEmpty()).isTrue()

        array.set(0, "Kotlin")
        array.set(1, "is really")
        array.set(2, "awesome")

        assertThat(array.isEmpty()).isFalse()

        assertThat(array.size()).isEqualTo(3)
        assertThat(array.get(0)).isEqualTo("Kotlin")
        assertThat(array.get(1)).isEqualTo("is really")
        assertThat(array.get(2)).isEqualTo("awesome")
    }

    @Test
    fun `Should Insert Into Array`() {
        val array = DynamicArray<Int>(4)
        array.set(0,0)
        array.set(1,1000)
        array.set(2,2000)
        array.set(3,3000)

        array.insert(1, 999)

        assertThat(array.size()).isEqualTo(5)
        assertThat(array.get(0)).isEqualTo(0)
        assertThat(array.get(1)).isEqualTo(999)
        assertThat(array.get(2)).isEqualTo(1000)
        assertThat(array.get(3)).isEqualTo(2000)
        assertThat(array.get(4)).isEqualTo(3000)
    }

    @Test @Ignore
    fun `Should Insert Then Add To Array`() {
        val array = DynamicArray<String>(0)
        array.insert(0, "insert 0")
        array.insert(1, "insert 1")

        array.add("add")

        assertThat(array.size()).isEqualTo(3)
    }

    @Test
    fun `Should Add To Array`() {
        val array = DynamicArray<String>(0)

        array.add("add")
        array.add("add2")

        assertThat(array.size()).isEqualTo(2)
    }

    @Test
    fun `Should Delete From Array`() {
        val array = DynamicArray<String>(0)

        array.add("will be deleted")
        array.add("won't be deleted")
        array.add("won't be deleted2")

        array.delete(0)

        assertThat(array.size()).isEqualTo(2)
        assertThat(array.get(0)).isEqualTo("won't be deleted")
        assertThat(array.get(1)).isEqualTo("won't be deleted2")
    }

    @Test
    fun `Should Verify If Contains Same Value`() {
        val array = DynamicArray<String>(0)

        array.add("text2")
        array.add("text1")

        assertThat(array.contains("text1")).isTrue()
        assertThat(array.contains("unknown")).isFalse()
    }
}