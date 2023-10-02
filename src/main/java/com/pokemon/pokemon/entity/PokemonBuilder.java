package com.pokemon.pokemon.entity;

import java.util.Collection;

public class PokemonBuilder {
    final String pokemonName;
    final Integer pokedexNumber;
    final Pokemon.Generation generation;
    Pokemon.Gender gender;
    Float weight;
    Float height;
    Stats stats;
    Long level;
    Collection<String> moves;
    String nickname;

    public PokemonBuilder(String pokemonName, int pokedexNumber, Pokemon.Generation generation) {
        this.pokemonName = pokemonName;
        this.pokedexNumber = pokedexNumber;
        this.generation = generation;
    }

    public PokemonBuilder setGender(Pokemon.Gender gender) {
        this.gender = gender;
        return this;
    }

    public PokemonBuilder setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public PokemonBuilder setHeight(Float height) {
        this.height = height;
        return this;
    }

    public PokemonBuilder setStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    public PokemonBuilder setLevel(Long level) {
        this.level = level;
        return this;
    }

    public PokemonBuilder setMoves(Collection<String> moves) {
        this.moves = moves;
        return this;
    }

    public PokemonBuilder setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }


}
