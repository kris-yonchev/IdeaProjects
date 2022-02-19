package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class AllCapitals {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt");


        PrintWriter writer = new PrintWriter("output.txt");

        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            writer.write(line.toUpperCase());
            writer.println();
        }

        writer.close();
    }
}
