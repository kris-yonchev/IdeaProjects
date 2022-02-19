package reflectionsAndAnnotationsExercise.barracksWars.models.units;

public class Gunner extends AbstractUnit {

    private static final int GUNNED_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNED_HEALTH, GUNNER_DAMAGE);
    }
}
