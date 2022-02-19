package FundamentalsExercise7;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companies = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split(" -> ");
            String companyName = info[0];
            String employeeId = info[1];

            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new ArrayList<>());
            }
            if (!companies.get(companyName).contains(employeeId)) {
                companies.get(companyName).add(employeeId);
            }


            input = scanner.nextLine();
        }
        companies.forEach((key, ids) -> {
            System.out.println(key);
            ids.forEach(id -> System.out.println("-- " + id));
        });
    }
}
