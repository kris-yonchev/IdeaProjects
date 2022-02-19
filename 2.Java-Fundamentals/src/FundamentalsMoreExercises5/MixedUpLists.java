package FundamentalsMoreExercises5;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> remainingElements = new ArrayList<>();
        List<Integer> mergedLists = new ArrayList<>();
        if (list1.size() > list2.size()) {
            remainingElements.add(list1.get(list1.size() - 1));
            remainingElements.add(list1.get(list1.size() - 2));
            list1.remove(list1.size() - 1);
            list1.remove(list1.size() - 1);
        } else {
            remainingElements.add(list2.get(0));
            remainingElements.add(list2.get(1));
            list2.remove(0);
            list2.remove(0);
        }
        Collections.reverse(list2);
        for (int i = 0; i < list1.size(); i++) {
            mergedLists.add(list1.get(i));
            mergedLists.add(list2.get(i));
        }
        Collections.sort(remainingElements);
        Collections.sort(mergedLists);
        for (Integer mergedList : mergedLists) {
            if (mergedList > remainingElements.get(0) && mergedList < remainingElements.get(1)) {
                System.out.print(mergedList + " ");
            }
        }


    }
}
