package Exercises;

import java.util.Scanner;

public class FishMarkt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double prskumria = Double.parseDouble(scanner.nextLine());
        double prcaca = Double.parseDouble(scanner.nextLine());
        double kgpalamud = Double.parseDouble(scanner.nextLine());
        double kgsafrid = Double.parseDouble(scanner.nextLine());
        double kgmidi = Double.parseDouble(scanner.nextLine());
        double prpalamud = prskumria + (prskumria * 0.6);
        double prsafrid = prcaca + (prcaca * 0.8);
        double prmidi = kgmidi * 7.50;
        double sumsafrid = prsafrid * kgsafrid;
        double sumpalamud = prpalamud * kgpalamud;
        System.out.printf("%.2f", prmidi + sumpalamud + sumsafrid);

    }
}
