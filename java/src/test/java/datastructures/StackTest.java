package datastructures;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StackTest {

    @Test(expected = IllegalStateException.class)
    public void shouldExpectAExceptionBecauseHeadIsNull() {
        final var stack = new Stack<Integer>();

        stack.pop();
    }

    @Test
    public void shouldPushThanPopFromStack() {
        final var stack = new Stack<String>();
        stack.push("holla");
        stack.push("hello");
        stack.push("olá");

        assertThat(stack.getSize(), is(3));

        final var ola = stack.pop();
        assertThat(stack.getSize(), is(2));
        assertThat(ola, is("olá"));

        final var hello = stack.pop();
        assertThat(stack.getSize(), is(1));
        assertThat(hello, is("hello"));

        final var holla = stack.pop();
        assertThat(stack.getSize(), is(0));
        assertThat(holla, is("holla"));
    }

    @Test
    public void shouldVerifyIfIsEmpty() {
        final var stack = new Stack<Array>();

        assertTrue(stack.isEmpty());
    }
}