package StreamsFilesAndDirectoriesExercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\words.txt");

        Path pathTwo = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\text.txt");

        PrintWriter writer = new PrintWriter("results.txt");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        List<String> words = Files.readAllLines(path);

        for (String line : words) {
            Arrays.stream(line.split("\\s+")).forEach(word -> map.putIfAbsent(word, 0));
        }

        for (String line : Files.readAllLines(pathTwo)) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
            });
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            writer.println(entry.getKey() + " - " + entry.getValue());

        }
        writer.close();


//        map.entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue())).forEach(e -> {
//            System.out.printf("%s - %d\n", e.getKey(), e.getValue());
//        });

    }
}
