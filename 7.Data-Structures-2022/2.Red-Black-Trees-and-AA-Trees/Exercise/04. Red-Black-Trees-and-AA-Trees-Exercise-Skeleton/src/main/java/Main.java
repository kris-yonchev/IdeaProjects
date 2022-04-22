import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        AATree<Integer> aaTree = new AATree<>();

        aaTree.insert(1);
        aaTree.insert(4);
        aaTree.insert(7);
        aaTree.insert(2);
        aaTree.insert(3);

        aaTree.postOrder(System.out::println);
        System.out.println();
    }
}
