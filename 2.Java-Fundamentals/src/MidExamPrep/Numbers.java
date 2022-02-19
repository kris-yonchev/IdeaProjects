package MidExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (Integer integer : numbers) {
            sum += integer;
        }
        double averageNumber = 1.0 * sum / numbers.size();
        List<Integer> topNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number > averageNumber) {
                topNumbers.add(number);
            }
        }
        Collections.sort(topNumbers);
        Collections.reverse(topNumbers);
        if (topNumbers.isEmpty()) {
            System.out.println("No");
        }
        for (int i = 0; i < topNumbers.size(); i++) {
            if (i == 5) {
                break;
            }
            System.out.print(topNumbers.get(i) + " ");
        }
    }
}
