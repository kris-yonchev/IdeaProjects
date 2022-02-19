package FundamentalsLecture2;

import java.util.Scanner;

public class VolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double pyramidVolume = (length * width * height) / 3;
        System.out.print("Length: Width: Height: ");
        System.out.printf("Pyramid Volume: %.2f", pyramidVolume);

    }
}
