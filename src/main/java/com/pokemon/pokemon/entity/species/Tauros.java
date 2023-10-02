package com.pokemon.pokemon.entity.species;

import com.pokemon.pokemon.dao.Specie;
import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.PokemonBuilder;
import com.pokemon.pokemon.entity.Types;
import com.pokemon.pokemon.entity.pokemonTypes.NormalType;

public class Tauros extends Pokemon implements NormalType {
    public final boolean hasEvolution;

    public Tauros(PokemonBuilder builder, Specie specie){
        super(builder);
        this.hasEvolution = specie.canEvolve;
    }

    @Override
    public long attackBonus(Types type) {
        return 1;
    }
}
