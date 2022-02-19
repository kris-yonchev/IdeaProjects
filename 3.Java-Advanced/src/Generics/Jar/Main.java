package Generics.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> intJar = new Jar<>();
        Jar<String> stringJar = new Jar<>();
        intJar.add(13);
        stringJar.add("pesho");
        stringJar.remove();
    }
}
