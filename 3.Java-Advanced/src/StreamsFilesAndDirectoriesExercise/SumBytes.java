package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != 10 && c != 13) {

                        sum += c;

                    }
                }
                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
