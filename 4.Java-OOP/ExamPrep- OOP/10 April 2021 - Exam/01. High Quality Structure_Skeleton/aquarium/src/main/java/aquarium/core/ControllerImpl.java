package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM;
import static aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        decorationRepository = new DecorationRepository();
        aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format("Successfully added %s.", aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorationRepository.add(decoration);
        return String.format("Successfully added %s.", type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        Decoration decoration = decorationRepository.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(NO_DECORATION_FOUND);
        }

        aquarium.addDecoration(decoration);
        decorationRepository.remove(decoration);

        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        Fish fish;

        switch (fishType) {
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        if (fish.getClass().getSimpleName().equals("FreshwaterFish")
                && aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") ||
                fish.getClass().getSimpleName().equals("SaltwaterFish")
                        && aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
            return WATER_NOT_SUITABLE;
        }
        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);


    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        aquarium.feed();
        return String.format("Fish fed: %d", aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        double fishSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format("The value of Aquarium %s is %.2f.", aquariumName, decorationSum + fishSum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

