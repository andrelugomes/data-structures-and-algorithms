package datastructures

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class QueueTest {

    @Test
    fun `Should Add To Queue`() {
        var queue = Queue<String>()
        queue.add("first...")

        assertThat(queue.size()).isEqualTo(1)
    }

    @Test
    fun `Should Remove From Queue`() {
        var queue = Queue<String>()
        queue.add("add 1")
        queue.add("add 2")
        queue.remove()
        queue.remove()
        assertThat(queue.size()).isEqualTo(0)
    }
}