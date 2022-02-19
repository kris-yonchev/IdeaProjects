package DefiningClassesExercise.Pokemon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PokemonMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int pokemonHp = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, pokemonHp);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {

            for (Map.Entry<String, Trainer> trainerEntry : trainers.entrySet()) {
                if (trainerEntry.getValue().pokeCollectionSize() > 0) {
                    boolean hasPokemon = false;
                    for (Pokemon pokemon : trainerEntry.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(input)) {
                            hasPokemon = true;
                            trainerEntry.getValue().setBadges();
                            break;
                        }
                    }
                    if (!hasPokemon) {
                        trainerEntry.getValue().missingPokemonPenalty();
                    }
                }
            }

            input = scanner.nextLine();
        }
        trainers.entrySet().stream().sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(e -> System.out.printf("%s %d %d\n", e.getKey(), e.getValue().getBadges(), e.getValue().pokeCollectionSize()));
    }
}
