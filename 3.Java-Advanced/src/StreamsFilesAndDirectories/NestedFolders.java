package StreamsFilesAndDirectories;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {

        Path path = Paths.get("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\Files-and-Streams");
        File file = path.toFile();
        ArrayDeque<File> stack = new ArrayDeque<>();
        stack.offer(file);

        int count = 1;

        while (!stack.isEmpty()) {
            File current = stack.poll();
            File[] nestedFolder = current.listFiles();
            for (File nestedFile : nestedFolder) {
                if (nestedFile.isDirectory()) {
                    stack.offer(nestedFile);
                    count++;
                }
            }
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
