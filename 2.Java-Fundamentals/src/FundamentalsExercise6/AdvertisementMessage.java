package FundamentalsExercise6;

import java.util.*;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> phrases = new ArrayList<>() {{
            add("Excellent product.");
            add("Such a great product.");
            add("I always use that product.");
            add("Best product of its category.");
            add("Exceptional product.");
            add("I can’t live without this product.");

        }};
        List<String> events = Arrays.asList("Now I feel good.", "I have succeeded with this product."
                , "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome."
                , "Try it yourself, I am very satisfied.", "I feel great!");
        List<String> authors = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String randomPhrase = phrases.get(random.nextInt(phrases.size()));
            String randomEvent = events.get(random.nextInt(events.size()));
            String randomAuthor = authors.get(random.nextInt(authors.size()));
            String randomCity = cities.get(random.nextInt(cities.size()));
            System.out.printf("%s %s %s - %s\n", randomPhrase, randomEvent, randomAuthor, randomCity);
        }

    }
}
