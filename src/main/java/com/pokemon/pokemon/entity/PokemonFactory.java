package com.pokemon.pokemon.entity;

import com.pokemon.pokemon.dao.Specie;
import com.pokemon.pokemon.entity.species.*;

import java.lang.reflect.InvocationTargetException;

public class PokemonFactory {

    public static Pokemon getPokemon(String pokemonName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Specie specie = Specie.valueOfByName(pokemonName);
        PokemonBuilder builder = getPokemonBuilder(specie);
        return createPokemon(specie, builder);
    }
    public static PokemonBuilder getPokemonBuilder(Specie specie){
        PokemonBuilder builder = new PokemonBuilder(specie.pokemonName,
                specie.pokedexNumber, specie.generation);
        builder.setGender(Math.random() * 10 >= 5 ? Pokemon.Gender.FEMALE : Pokemon.Gender.MALE);
        builder.setHeight((float) (Math.random() * 100));
        builder.setLevel((long) (Math.random() * 20));
        builder.setWeight((float) (Math.random() * 100));
        builder.setMoves(specie.initialMoves);
        return  builder;
    }
    static Pokemon createPokemon(Specie specie, PokemonBuilder builder) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class pokemonClass = specie.pokemonClass;

        Object obj = pokemonClass.getDeclaredConstructor(PokemonBuilder.class, Specie.class)
                .newInstance(builder, specie);
        //return (Pokemon) obj;
        return switch (obj){////v17
            case Eevee e -> e;
            case Tauros t -> t;
            case Ponyta p -> p;
            case Rapidash r -> r;
            case Jolteon j -> j;
            default -> throw new PokemonNotFoundException();
        };
        /**
        if(obj instanceof Eevee){
            return (Evee) obj;
        } else if (obj instanceof Tauros) {
            return new Tauros(builder, specie);
        } else if (o) {
            
        }**/
        //throw new PokemonNotFoundException();
    }
}
