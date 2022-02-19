package Exercise4;

import java.util.Scanner;

public class FootballStadium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());
        int afans = 0;
        int bfans = 0;
        int vfans = 0;
        int gfans = 0;
        for (int i = 1; i <= fans; i++) {
            String sector = scanner.nextLine();
            switch (sector) {
                case "A":
                    afans++;
                    break;
                case "B":
                    bfans++;
                    break;
                case "V":
                    vfans++;
                    break;
                case "G":
                    gfans++;
                    break;
            }
        }
        double FansA = 1.0 * afans / fans * 100;
        double FansB = 1.0 * bfans / fans * 100;
        double FansV = 1.0 * vfans / fans * 100;
        double FansG = 1.0 * gfans / fans * 100;
        double totalfans = 1.0 * fans / capacity * 100;
        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%", FansA, FansB, FansV, FansG, totalfans);
    }
}
