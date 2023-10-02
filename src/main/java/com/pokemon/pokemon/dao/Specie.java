package com.pokemon.pokemon.dao;

import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.species.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Specie {

    EEEVE("Eevee", 133, Pokemon.Generation.I, true, Arrays.asList("Covet", "Tail Whip", "Quick Attack", "Sand Attack"), setEvolutions("eevee"), Eevee.class),
    JOLTEON("Jolteon", 135, Pokemon.Generation.I, false, Arrays.asList("Bite", "Thunder Fang", "Agility", "Last Resort"), null, Jolteon.class),
    TAUROS("Tauros", 128, Pokemon.Generation.I, false, Arrays.asList("Tackle", "Tail Whip", "Work Up", "PayBack"), null, Tauros.class),
    PONYTA("Ponyta", 77, Pokemon.Generation.I, true, Arrays.asList("Tackle", "Tail Whip", "Fire Spin", "Agility"), setEvolutions("ponyta"), Ponyta.class),
    RAPIDASH("Rapidash", 78, Pokemon.Generation.I, false, Arrays.asList("Flame Charge", "Stomp", "Fire Blast", "Agility"), null, Rapidash.class),
    ;

    public final Map<String, String> evolutionsMap;
    public final String pokemonName;
    public final Integer pokedexNumber;
    public final Pokemon.Generation generation;
    public final boolean canEvolve;
    public final List<String> initialMoves;
    public final Class pokemonClass;



    private Specie(String pokemonName, int pokedexNumber, Pokemon.Generation generation,
                   boolean canEvolve, List<String> moves, Map<String, String> evolutionsMap, Class pokemonClass) {
        this.evolutionsMap = evolutionsMap;
        this.pokemonName = pokemonName;
        this.pokedexNumber = pokedexNumber;
        this.generation = generation;
        this.canEvolve = canEvolve;
        this.initialMoves = moves;
        this.pokemonClass = pokemonClass;
    }

    public static Specie valueOfByName(String name){
        for(Specie specie : values()){
            if(specie.pokemonName.toLowerCase().equals(name.toLowerCase())){
                return specie;
            }
        }
        return null;
    }

    ///Arrays.asList("rapidash"), Arrays.asList("L-40-rapidash"),
    private static Map<String, String> setEvolutions(String pokemonName){
        Map<String, String> map = new HashMap<>();
        switch (pokemonName.toLowerCase()){
            case "eevee":
                map.put("Vaporeon", "WaterStone");
                map.put("Jolteon", "ThunderStone");
                map.put("Flareon", "FireStone");
                break;
            case "ponyta":
                map.put("Rapidash","40");
                break;
            default:
                map = null;
        }
        return map;
    }
}
