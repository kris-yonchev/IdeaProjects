package FundamentalsMoreExercises3;


import java.util.Arrays;
import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxLength = 0;
        int lastIndex = -1;

        int[] length = new int[numbers.length];
        int[] previous = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            length[i] = 1;
            previous[i] = -1;

            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && length[j] >= length[i]) {
                    length[i] = length[j] + 1;
                    previous[i] = j;
                }

            }
            if (length[i] > maxLength) {
                maxLength = length[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1) {
            lis[currentIndex] = numbers[lastIndex];
            currentIndex--;
            lastIndex = previous[lastIndex];
        }
        for (int li : lis) {
            System.out.print(li + " ");
        }


    }
}
