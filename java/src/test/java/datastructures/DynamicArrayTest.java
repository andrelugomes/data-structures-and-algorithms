package datastructures;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    @Test
    public void shouldTestGetByIndex(){
        var array = new DynamicArray<>(2);

        assertThat(array.get(0), is(nullValue()));
        assertThat(array.get(1), is(nullValue()));
    }

    @Test
    public void shouldTestSet(){
        var strings = new DynamicArray<String>(1);
        strings.set(0, "Cool String");

        assertThat(strings.get(0), is("Cool String"));

        var numbers = new DynamicArray<Integer>(1);
        numbers.set(0, 123);

        assertThat(numbers.get(0), is(123));
    }

    @Test
    public void shouldAddAndResizeArray(){
        var strings = new DynamicArray<String>(2);

        assertThat(strings.size(), is(0));

        strings.add("André");
        strings.add("Luis");
        strings.add("Gomes");

        assertThat(strings.size(), is(3));
    }

    @Test
    public void shouldInsertIntoArray(){
        var array = new DynamicArray<Integer>(1);
        array.insert(2,333);
        array.insert(0,123);
        array.insert(1,321);

        assertThat(array.size(), is(3)); //capacity 4
    }

    @Test
    public void shouldDeleteFromArray(){
        var array = new DynamicArray<>(2);
        array.add("object1");
        array.add("object2");
        array.add("object3");

        array.delete(1);

        assertThat(array.size(), is(2));
        assertThat(array.get(0), is("object"));
    }

    @Test
    public void shouldDeleteLastFromArray(){
        var array = new DynamicArray<>(1);
        array.add("first");
        array.add("last");

        array.delete(1);

        assertThat(array.size(), is(1));
        assertThat(array.get(0), is("first"));
    }

    @Test
    public void shouldTestIsEmpty(){
        var array = new DynamicArray<>(1);

        assertThat(array.isEmpty(), is(true));
    }

    @Test
    public void shouldTestContains(){
        var strings = new DynamicArray<String>(2);
        strings.add("André");

        assertThat(strings.contains("André"), is(true));
        assertThat(strings.contains("Luis"), is(false));
    }
}