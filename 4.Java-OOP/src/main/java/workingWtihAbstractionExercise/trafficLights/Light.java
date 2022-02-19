package workingWtihAbstractionExercise.trafficLights;

public enum Light {
    GREEN,
    YELLOW,
    RED;

    public static Light changeLight(Light light) {
        switch (light) {
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            case RED:
                return GREEN;
            default:
                throw new IllegalArgumentException("Wrong color!");
        }
    }
}
