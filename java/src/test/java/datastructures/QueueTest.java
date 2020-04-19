package datastructures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void shouldAddToQueue() {
        Queue<String> queue = new Queue<>();

        queue.add("first");
        queue.add("second");
        queue.add("third");

        assertThat(queue.getSize(), is(3));
    }

    @Test
    public void shouldRemoveFromQueue() {
        Queue<String> queue = new Queue<>();

        queue.add("item1");
        queue.add("item2");
        queue.add("item3");

        assertThat(queue.getSize(), is(3));

        var item1 = queue.remove();
        var item2 = queue.remove();
        var item3 = queue.remove();

        assertThat(queue.getSize(), is(0));
        assertThat(item1, is("item1"));
        assertThat(item2, is("item2"));
        assertThat(item3, is("item3"));
    }

    @Test
    public void shouldRemoveFromEmptyQueue() {
        Queue<String> queue = new Queue<>();

        var item = queue.remove();

        assertThat(queue.getSize(), is(0));
        assertNull(item);
    }
}