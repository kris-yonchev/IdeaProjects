package ExamExercise;

import java.util.Scanner;

public class OrderDograma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int frames = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String delivery = scanner.nextLine();
        double price = 0.0;
        switch (type) {
            case "90X130":
                price = frames * 110;
                if (frames > 60) {
                    price *= 0.92;
                } else if (frames > 30) {
                    price *= 0.95;
                }
                break;
            case "100X150":
                price = frames * 140;
                if (frames > 80) {
                    price *= 0.9;
                } else if (frames > 40) {
                    price *= 0.94;
                }
                break;
            case "130X180":
                price = frames * 190;
                if (frames > 50) {
                    price *= 0.88;
                } else if (frames > 20) {
                    price *= 0.93;
                }
                break;
            case "200X300":
                price = frames * 250;
                if (frames > 50) {
                    price *= 0.86;
                } else if (frames > 25) {
                    price *= 0.91;
                }
                break;
        }
        if (delivery.equals("With delivery")) {
            price += 60;
        }
        if (frames >= 100) {
            price *= 0.96;
        }
        if (frames <= 10) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN", price);
        }
    }
}
