package MidExam;

import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> messages = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Chat":
                    messages.add(command[1]);
                    break;
                case "Delete":
                    messages.remove(command[1]);
                    break;
                case "Edit":
                    if (messages.contains(command[1])) {
                        int index = messages.indexOf(command[1]);
                        messages.set(index, command[2]);
                    }
                    break;
                case "Pin":
                    if (messages.contains(command[1])) {
                        messages.remove(command[1]);
                        messages.add(command[1]);
                    }
                    break;
                case "Spam":
                    messages.addAll(Arrays.asList(command).subList(1, command.length));
                    break;
            }
            input = scanner.nextLine();
        }
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
