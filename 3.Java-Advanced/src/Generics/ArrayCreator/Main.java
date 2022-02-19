package Generics.ArrayCreator;


public class Main {
    public static void main(String[] args) {
        Integer [] ints = ArrayCreator.create(10, 13);

        String [] strings = ArrayCreator.<String>create(String.class, 3, "asd");




    }
}
