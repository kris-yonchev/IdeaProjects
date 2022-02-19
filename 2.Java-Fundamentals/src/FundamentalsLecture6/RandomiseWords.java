package FundamentalsLecture6;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomiseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Random random = new Random();
        while (!words.isEmpty()) {
            String word = words.get(random.nextInt(words.size()));
            words.remove(word);
            System.out.println(word);
        }
    }
}
