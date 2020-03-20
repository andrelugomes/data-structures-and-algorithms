package datastructures;

public class Arrays {

    public static void main(String[] args) {
        var ints = new int[10]; //fixed size
        ints[0] = 1;

        System.out.println(ints[0]);

        var anything = new Object[2]; //Can hold anything as Objects
        anything[0] = "String";
        anything[1] = 123;

        System.out.println(anything);

    }
}
