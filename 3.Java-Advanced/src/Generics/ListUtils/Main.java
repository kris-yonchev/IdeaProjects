package Generics.ListUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        List<String> stringList = List.of("1", "2", "3", "4", "5", "5");
        System.out.println(ListUtils.getMax(intList));
        System.out.println(ListUtils.getMin(stringList));
    }
}
