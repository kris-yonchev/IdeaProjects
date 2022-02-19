package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputOne.txt");

        Path pathTwo = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputTwo.txt");

        List<String> one = Files.readAllLines(path);
        List<String> two = Files.readAllLines(pathTwo);

        PrintWriter writer = new PrintWriter("merge.txt");

        for (String s : one) {
            writer.println(s);
        }
        for (String s : two) {
            writer.println(s);
        }
        writer.close();
    }
}
