package IteratorAndComparatorExercise.Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stones = scanner.nextLine().split(", ");
        Lake lake = new Lake(Arrays.stream(stones).map(Integer::parseInt).collect(Collectors.toList()));
        List<String> output = new ArrayList<>();
        for (Integer integer : lake) {
            output.add(String.valueOf(integer));
        }
        System.out.println(String.join(", ", output));

    }
}
