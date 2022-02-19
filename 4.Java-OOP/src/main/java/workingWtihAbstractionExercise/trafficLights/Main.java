package workingWtihAbstractionExercise.trafficLights;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lights = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Light> que = Arrays
                .stream(lights).map(Light::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));


        for (int i = 0; i < n; i++) {
            changeLights(que);
            System.out.println(que.toString().replaceAll("[\\[\\],]", "").trim());
        }
    }

    private static ArrayDeque<Light> changeLights(ArrayDeque<Light> que) {
        for (int i = 0; i < que.size(); i++) {
            que.offer(Light.changeLight(que.poll()));
        }
        return que;
    }
}
