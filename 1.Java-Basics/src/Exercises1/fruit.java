package Exercises;

import java.util.Scanner;

public class fruit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double prstraw = Double.parseDouble(scanner.nextLine());
        double banana = Double.parseDouble(scanner.nextLine());
        double orange = Double.parseDouble(scanner.nextLine());
        double berries = Double.parseDouble(scanner.nextLine());
        double straw = Double.parseDouble(scanner.nextLine());
        double prberries = prstraw - (prstraw * 0.5);
        double proranges = prberries - (prberries * 0.4 );
        double prbanana = prberries - (prberries * 0.8 );
        double sumberries = berries * prberries ;
        double sumoranges = orange * proranges ;
        double sumbanana = banana * prbanana ;
        double sumstraw = straw * prstraw ;
        System.out.printf("%.2f", sumberries + sumbanana + sumoranges + sumstraw);
    }
}
