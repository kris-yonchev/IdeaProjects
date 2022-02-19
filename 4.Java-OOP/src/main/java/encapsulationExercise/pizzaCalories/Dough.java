package encapsulationExercise.pizzaCalories;

import java.util.Map;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private Map<String, Double> FLOUR_VALUES = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0);
    private Map<String, Double> FLOUR_TECHNIQUE_VALUES = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_VALUES.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!FLOUR_TECHNIQUE_VALUES.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * FLOUR_VALUES.get(this.flourType) * FLOUR_TECHNIQUE_VALUES.get(this.bakingTechnique);
    }
}
