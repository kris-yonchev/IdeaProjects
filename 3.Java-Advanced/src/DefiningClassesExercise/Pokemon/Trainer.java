package DefiningClassesExercise.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Trainer {
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setBadges() {
        this.badges++;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(this.pokemons);
    }

    public int pokeCollectionSize() {
        return this.pokemons.size();
    }

    private Function<Pokemon, Pokemon> hurtPokemon = p ->
            new Pokemon(p.getName(), p.getElement(), p.getHp() - 10);

    public void missingPokemonPenalty() {
        this.pokemons = this.pokemons.stream().map(hurtPokemon).filter(e -> e.getHp() > 0).collect(Collectors.toList());
    }

    public int getBadges() {
        return badges;
    }
}
