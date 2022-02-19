package LastExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@#+(?<productName>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                String name = matcher.group("productName");
                StringBuilder group = new StringBuilder();
                for (int index = 0; index < name.length(); index++) {
                    char symbol = name.charAt(index);
                    if (Character.isDigit(symbol)) {
                        group.append(symbol);
                    }
                }
                if (group.toString().equals("")) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + group);
                }


            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
