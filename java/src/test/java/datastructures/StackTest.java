package datastructures;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StackTest {

    @Test(expected = IllegalStateException.class)
    public void shouldExpectAExceptionBecauseHeadIsNull() {
        var stack = new Stack<Integer>();

        stack.pop();
    }

    @Test
    public void shouldPushThanPopFromStack() {
        var stack = new Stack<String>();
        stack.push("hi");
        stack.push("hello");
        stack.push("olá");

        assertThat(stack.getSize(), is(3));

        var ola = stack.pop();
        assertThat(stack.getSize(), is(2));
        assertThat(ola, is("olá"));

        var hello = stack.pop();
        assertThat(stack.getSize(), is(1));
        assertThat(hello, is("hello"));

        var hi = stack.pop();
        assertThat(stack.getSize(), is(0));
        assertThat(hi, is("hi"));
    }

    @Test
    public void shouldVerifyIfIsEmpty() {
        var stack = new Stack<Array>();

        assertTrue(stack.isEmpty());
    }
}