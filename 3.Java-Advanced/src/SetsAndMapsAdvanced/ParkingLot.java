package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] info = input.split(", ");
            if (info[0].equals("IN")) {
                parkingLot.add(info[1]);
            } else {
                parkingLot.remove(info[1]);
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String id : parkingLot) {
                System.out.println(id);
            }
        }
    }
}
