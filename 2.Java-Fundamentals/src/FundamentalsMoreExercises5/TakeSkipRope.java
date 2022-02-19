package FundamentalsMoreExercises5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();
        List<Integer> numberList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < encryptedMessage.length(); i++) {

            if (encryptedMessage.charAt(i) >= 48 && encryptedMessage.charAt(i) <= 57) {
                numberList.add(Character.getNumericValue(encryptedMessage.charAt(i)));
            } else {
                charList.add(encryptedMessage.charAt(i));
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();


        for (int index = 0; index < numberList.size(); index++) {
            if (index % 2 == 0) {
                takeList.add(numberList.get(index));
            } else {
                skipList.add(numberList.get(index));
            }
        }

        StringBuilder result = new StringBuilder();

        int currentIndex = 0;
        for (int index = 0; index < takeList.size(); index++) {
            int takeCount = takeList.get(index);
            int skipCount = skipList.get(index);
            if (currentIndex + takeCount > charList.size()) {
                takeCount = charList.size() - currentIndex;
            }
            for (int i = 0; i < takeCount; i++) {
                result.append(charList.get(currentIndex + i));
            }
            currentIndex += takeCount + skipCount;

        }
        System.out.println(result);
    }
}



