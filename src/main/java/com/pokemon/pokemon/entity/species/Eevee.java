package com.pokemon.pokemon.entity.species;

import com.pokemon.pokemon.dao.Specie;
import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.PokemonBuilder;
import com.pokemon.pokemon.entity.PokemonFactory;
import com.pokemon.pokemon.entity.Types;
import com.pokemon.pokemon.entity.pokemonTypes.NormalType;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class Eevee extends Pokemon implements NormalType{

    public final boolean hasEvolution;
    public final Map<String, String> evolutionsMap;

    public Eevee(PokemonBuilder builder, Specie specie){
        super(builder);
        this.hasEvolution = specie.canEvolve;
        this.evolutionsMap = specie.evolutionsMap;
    }

    public Eevee() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(PokemonFactory.getPokemonBuilder(Specie.valueOfByName("eevee")));
        Specie specie = Specie.valueOfByName("eevee");
        this.hasEvolution = specie.canEvolve;
        this.evolutionsMap = specie.evolutionsMap;
    }
    public Pokemon evolve(String pokemonName) {
        try {
            return PokemonFactory.getPokemon(pokemonName);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pokemon setItem(String item){
        super.setItem(item);
        return evolutionsMap
                .values()
                .stream()
                .anyMatch(v -> v.equalsIgnoreCase(item))
                ? evolve(evolutionsMap
                            .entrySet()
                            .stream()
                            .filter(e -> e.getValue().equalsIgnoreCase(item))
                            .map(e -> e.getKey()).findAny().get())
                : this;
    }

    @Override
    public long attackBonus(Types type) {
        return 1;
    }
}
