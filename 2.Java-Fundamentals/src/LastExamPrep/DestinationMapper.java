package LastExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> places = new ArrayList<>();
        String input = scanner.nextLine();
        String regex = "(?<separator>[=\\/])(?<place>[A-Z][A-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            places.add(matcher.group("place"));
        }
        int travelPoints = places.stream().mapToInt(String::length).sum();
        System.out.printf("Destinations: %s\nTravel Points: %d", String.join(", ", places), travelPoints);

    }
}
