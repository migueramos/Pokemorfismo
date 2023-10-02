package com.pokemon.pokemon.entity.species;

import com.pokemon.pokemon.dao.Specie;
import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.PokemonBuilder;
import com.pokemon.pokemon.entity.Types;
import com.pokemon.pokemon.entity.pokemonTypes.FireType;

public class Rapidash extends Pokemon implements FireType {

    public final boolean hasEvolution;
    public Rapidash(PokemonBuilder pokemonBuilder, Specie specie) {
        super(pokemonBuilder);
        this.hasEvolution = specie.canEvolve;
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
