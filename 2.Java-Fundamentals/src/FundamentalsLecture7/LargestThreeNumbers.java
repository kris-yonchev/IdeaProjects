package FundamentalsLecture7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        Arrays.stream(nums)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(integer -> System.out.print(integer + " "));
    }
}
