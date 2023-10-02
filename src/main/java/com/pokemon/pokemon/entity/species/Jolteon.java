package com.pokemon.pokemon.entity.species;

import com.pokemon.pokemon.dao.Specie;
import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.PokemonBuilder;
import com.pokemon.pokemon.entity.Types;
import com.pokemon.pokemon.entity.pokemonTypes.ElectricType;

public class Jolteon extends Pokemon implements ElectricType {

    public final boolean hasEvolution;
    public Jolteon(PokemonBuilder pokemonBuilder, Specie specie) {
        super(pokemonBuilder);
        this.hasEvolution = specie.canEvolve;
    }
    @Override
    public long AttackBonus(Types type) {
        return 0;
    }
}
