package datastructures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void shouldAddToQueue() {
        final Queue<String> queue = new Queue<>();

        queue.add("first");
        queue.add("second");
        queue.add("third");

        assertThat(queue.getSize(), is(3));
    }

    @Test
    public void shouldRemoveFromQueue() {
        final Queue<String> queue = new Queue<>();

        queue.add("item1");
        queue.add("item2");
        queue.add("item3");

        assertThat(queue.getSize(), is(3));

        final var item1 = queue.remove();
        final var item2 = queue.remove();
        final var item3 = queue.remove();

        assertThat(queue.getSize(), is(0));
        assertThat(item1, is("item1"));
        assertThat(item2, is("item2"));
        assertThat(item3, is("item3"));
    }

    @Test
    public void shouldRemoveFromEmptyQueue() {
        final Queue<String> queue = new Queue<>();

        final var item = queue.remove();

        assertThat(queue.getSize(), is(0));
        assertNull(item);
    }
}