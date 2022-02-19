package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputLineNumbers.txt");

        List<String> allLines = Files.readAllLines(path);

        PrintWriter writer = new PrintWriter("output.txt");
        int count = 1;
        for (String line : allLines) {
            writer.write(count+". "+ line);
            writer.println();
            count++;
        }
        writer.close();
    }
}
