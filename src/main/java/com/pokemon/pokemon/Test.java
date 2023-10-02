package com.pokemon.pokemon;

import com.pokemon.pokemon.entity.Pokemon;
import com.pokemon.pokemon.entity.PokemonFactory;
import com.pokemon.pokemon.entity.Types;
import com.pokemon.pokemon.entity.pokemonTypes.NormalType;
import com.pokemon.pokemon.entity.species.*;

public class Test {
    public static void main(String[] args) throws Exception {

        Pokemon pokemon = PokemonFactory.getPokemon("eevee");
        Eevee eevee = (Eevee) pokemon;

        eevee.attackBonus(Types.BUG);
        //pokemon.attackBonus(Types.BUG);

        NormalType normal = eevee;
        //normal.addExp(244);
        eevee.addExp(244);






        ///evolutionRules can't be reach from Pokemon reference
        ///System.out.println(pokemon.evolutionRules);
        System.out.println(eevee.evolutionsMap);
        ///evolutionRules can't be reach from NormalType reference
        //System.out.println(normal.evolutionRules);

        Pokemon pokemon2 = PokemonFactory.getPokemon("TAUROS");
        Tauros tauros = (Tauros) pokemon2;
        System.out.println(pokemon2);
        NormalType normal2 = tauros;
        //Eevee eevee1 = (Eevee) normal2;

        Pokemon ponyta = PokemonFactory.getPokemon("Ponyta");
        System.out.println(ponyta);
        while(ponyta instanceof Ponyta){
            ponyta = ponyta.levelUp();
        }
        System.out.println(ponyta);
        Rapidash rapidash = (Rapidash) ponyta;


        //Pokemon pokemon = PokemonFactory.getPokemon("eevee");
        System.out.println(pokemon);
        pokemon = pokemon.setItem("ThunderStone");
        System.out.println(pokemon);



    }
}
