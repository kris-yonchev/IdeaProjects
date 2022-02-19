package StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "F:\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "F:\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<Character> exceptions = new ArrayList<>();
        Collections.addAll(exceptions, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(inputPath)) {
            OutputStream out = new FileOutputStream(outputPath);
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!exceptions.contains((char)oneByte)) {
                    out.write(oneByte);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
