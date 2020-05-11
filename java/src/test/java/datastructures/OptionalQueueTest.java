package datastructures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OptionalQueueTest {

    @Test
    public void shouldAddThenRemoveFromQueue() {
        final var queue = new OptionalQueue<String>();

        queue.add("item1");
        queue.add("item2");

        assertThat(queue.getSize(), is(2));

        final var item1 = queue.safeRemove();
        final var item2 = queue.safeRemove();

        assertThat(queue.getSize(), is(0));
        assertTrue(item1.isPresent());
        assertThat(item1.get(), is("item1"));
        assertTrue(item2.isPresent());
        assertThat(item2.get(), is("item2"));
    }
}
