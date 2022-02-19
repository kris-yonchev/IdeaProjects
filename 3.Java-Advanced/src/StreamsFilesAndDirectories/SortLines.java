package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        Path inputPath = Paths.get("F:\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt");


        List<String> lines = Files.readAllLines(inputPath)
                .stream().sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("sorted.txt"), lines);


    }
}
