package StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("F:\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File [] listFiles = file.listFiles();
                for (File f : listFiles) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]\n", f.getName(), f.length());
                    }
                }
            }
        }

    }
}
