package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt");

//        List<String> allLines = Files.readAllLines(path);
//
//        allLines.stream().map(String::toCharArray).forEach(charArray -> {
//            int sum = 0;
//            for (char symbol : charArray) {
//                sum += symbol;
//            }
//            System.out.println(sum);
//        });

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while (line != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        }

    }
}
