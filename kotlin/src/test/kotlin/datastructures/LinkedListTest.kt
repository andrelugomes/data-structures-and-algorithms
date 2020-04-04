package datastructures

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class LinkedListTest {

    @Test
    fun `Should Add To Front`() {
        val list = LinkedList<String>()

        assertThat(list.isEmpty()).isTrue()

        list.addFront("add1")
        list.addFront("add2")

        assertThat(list.size()).isEqualTo(2)
    }

    @Test
    fun `Should Get The First And Last Element`() {
        val list = LinkedList<Int>()
        list.addFront(1)
        list.addFront(2)

        assertThat(list.size()).isEqualTo(2)
        assertThat(list.getLast()).isEqualTo(1)
        assertThat(list.getFirst()).isEqualTo(2)
    }

    @Test
    fun `Should Add To Back`() {
        val list = LinkedList<String>()
        list.addFront("head")

        list.addBack("tail")

        assertThat(list.size()).isEqualTo(2)
        assertThat(list.getLast()).isEqualTo("tail")
        assertThat(list.getFirst()).isEqualTo("head")
    }

    @Test
    fun `Should Delete from List`() {
        val list = LinkedList<Any>()
        list.addFront("add1")
        list.addFront(3)
        list.addFront("add2")

        list.delete(3)

        assertThat(list.size()).isEqualTo(2)
        assertThat(list.getLast()).isEqualTo("add1")
        assertThat(list.getFirst()).isEqualTo("add2")

    }

    @Test
    fun `Should Delete HEAD from List with size 1`() {
        val list = LinkedList<Any>()
        list.addFront("head")

        list.delete("head")

        assertThat(list.size()).isEqualTo(0)
    }

    @Test
    fun `Should Delete HEAD from List`() {
        val list = LinkedList<String>()
        list.addFront("add1")
        list.addFront("add2")
        list.addFront("add3")

        list.delete("add3")

        assertThat(list.size()).isEqualTo(2)
        assertThat(list.getLast()).isEqualTo("add1")
        assertThat(list.getFirst()).isEqualTo("add2")
    }

    @Test
    fun `Should Delete TAIL from List`() {
        val list = LinkedList<String>()
        list.addFront("add1")
        list.addFront("add2")
        list.addFront("add3")

        list.delete("add1")

        assertThat(list.size()).isEqualTo(2)
        assertThat(list.getLast()).isEqualTo("add2")
        assertThat(list.getFirst()).isEqualTo("add3")
    }
}