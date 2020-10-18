package datastructures

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StackTest {

    @Test
    fun `Should push To Stack`() {
        var stack = Stack<String>()
        stack.push("pushed.")
        stack.push("pushed..")
        stack.push("pushed...")

        assertThat(stack.size()).isEqualTo(3)
    }

    @Test
    fun `Should pop from Stack`() {
        var stack = Stack<String>()
        stack.push("apple")
        stack.push("banana")

        val banana = stack.pop()
        assertThat(stack.size()).isEqualTo(1)
        assertThat(banana).isEqualTo("banana")

        val apple = stack.pop()
        assertThat(stack.size()).isEqualTo(0)
        assertThat(apple).isEqualTo("apple")

    }
}