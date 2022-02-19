package FundamentalsLecture5;

import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int smallerList = Math.min(listOne.size(), listTwo.size());

        for (int i = 0; i < smallerList; i++) {
            System.out.print(listOne.get(i) + " " + listTwo.get(i) + " ");
        }
        getRemaining(listOne, smallerList);
        getRemaining(listTwo, smallerList);

    }

    private static void getRemaining(List<Integer> list, int beginIndex) {
        for (int i = beginIndex; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
