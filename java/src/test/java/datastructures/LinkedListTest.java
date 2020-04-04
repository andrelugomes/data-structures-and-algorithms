package datastructures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void shouldAddFrontOfList() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        assertThat(linkedList.getFirst(), is(3));
        assertThat(linkedList.getLast(), is(1));
    }

    @Test
    public void shouldAddBackOfList() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addBack(1);

        assertThat(linkedList.getFirst(), is(1));
        assertThat(linkedList.getLast(), is(1));
    }

    @Test
    public void shouldGetSize() {
        var linkedList = new LinkedList<String>();
        assertThat(linkedList.size(), is(0));
        assertThat(linkedList.count(), is(0));

        linkedList.addFront("add1");
        assertThat(linkedList.size(), is(1));
        assertThat(linkedList.count(), is(1));

        linkedList.addFront("add2");
        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.count(), is(2));
    }

    @Test
    public void shouldClearTheList() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        linkedList.clear();

        assertThat(linkedList.size(), is(0));
    }

    @Test
    public void shouldDeleteHeadFromListByValue() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        linkedList.delete(3);

        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.getFirst(), is(2));
        assertThat(linkedList.getLast(), is(1));
    }

    @Test
    public void shouldDeleteFromListByValue() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        linkedList.delete(2);

        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.getFirst(), is(3));
        assertThat(linkedList.getLast(), is(1));
    }


    @Test
    public void shouldDeleteTailFromListByValue() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        linkedList.delete(1);

        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.getFirst(), is(3));
        assertThat(linkedList.getLast(), is(2));
    }
}