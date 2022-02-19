package interfaceAndAbstractionExercise.collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split("\\s+");
        int timesToRemove = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        printAdd(items, addCollection);
        printAdd(items, addRemoveCollection);
        printAdd(items, myList);

        printRemove(timesToRemove, addRemoveCollection);
        printRemove(timesToRemove, myList);
    }

    private static void printAdd(String[] items, Addable collection) {
        for (String item : items) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();
    }

    private static void printRemove(int count, AddRemovable collection) {
        for (int i = 0; i < count; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
