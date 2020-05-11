package datastructures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    @Test
    public void shouldTestGetByIndex(){
        final var array = new DynamicArray<>(2);

        assertThat(array.get(0), is(nullValue()));
        assertThat(array.get(1), is(nullValue()));
    }

    @Test
    public void shouldTestSet(){
        final var strings = new DynamicArray<String>(2);
        strings.set(0, "Cool String");

        assertThat(strings.get(0), is("Cool String"));
        assertThat(strings.getSize(), is(1));

        final var numbers = new DynamicArray<Integer>(1);
        numbers.set(0, 123);

        assertThat(numbers.getSize(), is(1));
        assertThat(numbers.get(0), is(123));
    }

    @Test
    public void shouldAddAndResizeArray(){
        final var strings = new DynamicArray<String>(2);

        assertThat(strings.getSize(), is(0));

        strings.add("André");
        strings.add("Luis");
        strings.add("Gomes");

        assertThat(strings.getSize(), is(3));
    }

    @Test
    public void shouldInsertIntoArrayInOrder(){
        final var array = new DynamicArray<Integer>(1);

        //Ordered insertion
        array.insert(0,123);
        array.insert(1,321);
        array.insert(2,333);

        assertThat(array.getSize(), is(3));
    }

    @Test
    public void shouldDeleteFromArray(){
        final var array = new DynamicArray<>(2);
        array.add("object1");
        array.add("object2");
        array.add("object3");

        array.delete(1);

        assertThat(array.getSize(), is(2));
        assertThat(array.get(0), is("object1"));
    }

    @Test
    public void shouldDeleteLastFromArray(){
        final var array = new DynamicArray<>(1);
        array.add("first");
        array.add("last");

        array.delete(1);

        assertThat(array.getSize(), is(1));
        assertThat(array.get(0), is("first"));
    }

    @Test
    public void shouldDeleteLastFromArrayWithSize1(){
        final var array = new DynamicArray<>(1);
        array.add("one");

        array.delete(0);

        assertThat(array.getSize(), is(0));
    }

    @Test
    public void shouldTestIsEmpty(){
        final var array = new DynamicArray<>(1);

        assertThat(array.isEmpty(), is(true));
    }

    @Test
    public void shouldTestContains(){
        final var strings = new DynamicArray<String>(2);
        strings.add("André");

        assertThat(strings.contains("André"), is(true));
        assertThat(strings.contains("Luis"), is(false));
    }
}