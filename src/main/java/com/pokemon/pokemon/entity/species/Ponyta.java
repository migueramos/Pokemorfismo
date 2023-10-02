package com.pokemon.pokemon.entity.species;

import com.pokemon.pokemon.dao.Specie;
import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.PokemonBuilder;
import com.pokemon.pokemon.entity.PokemonFactory;
import com.pokemon.pokemon.entity.Types;
import com.pokemon.pokemon.entity.pokemonTypes.FireType;

import java.lang.reflect.InvocationTargetException;

public class Ponyta extends Pokemon implements FireType {

    public final boolean hasEvolution;

    private final Long evolvLevel;
    private final String evolution;
    public Ponyta(PokemonBuilder pokemonBuilder, Specie specie) {
        super(pokemonBuilder);
        this.hasEvolution = specie.canEvolve;
        if(hasEvolution){
            this.evolvLevel = Long.parseLong(specie.evolutionsMap
                    .values()
                    .stream()
                    .findFirst()
                    .get());
            this.evolution = specie.evolutionsMap
                    .keySet()
                    .stream()
                    .findFirst()
                    .get();
        }else{
            this.evolvLevel = null;
            this.evolution = null;
        }
    }

    public Pokemon evolve(String pokemonName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return PokemonFactory.getPokemon(pokemonName);
    }

    public Pokemon levelUp(){
        super.levelUp();
        try {
            return getLevel().equals(evolvLevel)
                    ? PokemonFactory.getPokemon(evolution)
                    : this;
        } catch (InvocationTargetException
                 | NoSuchMethodException
                 | InstantiationException
                 | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long AttackBonus(Types type) {
        switch (type){
            case WATER:
                return (long) 0.5;
            case GRASS:
                return 2;
        }
        return 1;
    }
}
