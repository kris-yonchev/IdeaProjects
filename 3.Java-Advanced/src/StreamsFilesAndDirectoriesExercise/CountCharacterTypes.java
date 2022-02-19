package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        int vowels = 0;
        int consonants = 0;
        int punctuations = 0;

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt");

        List<String> allLines = Files.readAllLines(path);

        PrintWriter writer = new PrintWriter("output.txt");

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                if (current!= 13 && current!=10 && current!=32) {
                    if (current=='a' || current=='e' || current=='i' || current=='o' || current=='u' ) {
                        vowels++;
                    } else if (current=='!' || current==',' || current=='.' || current=='?') {
                        punctuations++;
                    } else {
                        consonants++;
                    }
                }
            }
        }
        writer.write("Vowels: "+vowels+
                "\n"+"Consonants: "+consonants+
                "\n"+"Punctuation: "+punctuations);
        writer.close();
    }
}
