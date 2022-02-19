package StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources -Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources");

        int size = 0;
        for (File file : path.toFile().listFiles()) {
            if (!file.isDirectory()) {
                size += file.length();
            }
        }
        System.out.println("Folder size: "+size);
    }
}
