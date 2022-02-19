package SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            map.putIfAbsent(name, new ArrayList<>());
            for (double grade : scores) {
                map.get(name).add(grade);
            }
        }
        map.entrySet().stream().forEach(entry -> {
            double avg = 0;
            for (double val : entry.getValue()) {
                avg += val;
            }
            String pattern = "#.######################";
            DecimalFormat format = new DecimalFormat(pattern);
            System.out.printf("%s is graduated with %s\n", entry.getKey(), format.format(avg / entry.getValue().size()));
        });
    }
}

//        3
//        George
//        3.75 5
//        Maria
//        4.25 6
//        Peter
//        6 4.5

