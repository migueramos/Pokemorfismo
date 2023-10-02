package com.pokemon.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public abstract class Pokemon {
    final UUID pokemonId = UUID.randomUUID();
    String pokemonName;
    Integer pokedexNumber;
    Gender gender;
    Float weight;
    Float height;
    Stats stats;
    Generation generation;
    Long level;
    Collection<String> moves;
    String nickname;
    Double exp = 0d;
    String item;

    public enum Generation {
        I, II, III, IV, V, VI, VII, VIII, IX
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonName='" + pokemonName + '\'' +
                ", pokedexNumber=" + pokedexNumber +
                ", moves=" + moves +
                ", level=" + level +
                '}';
    }

    public enum Gender {
        MALE, FEMALE, UNKNOWN
    }

    public String getPokemonName() {
        return pokemonName;
    }






    public Pokemon levelUp(){
        this.level++;
        return this;
    }





    public Long getLevel(){
        return this.level;
    }
    public Collection<String> getMoves() {
        return moves;
    }

    public void attack(String move){

    }

    public void teachMove(String move){

    }

    public void learnMove(String move){

    }

    public void forgetMove(String move){

    }




    public Pokemon setItem(String item){
        this.item = item;
        return this;
    }







    public void addExp(double x){
        this.exp += x;
    }

    public void receiveAttack(long x){
        this.stats.HP  -= x;
    }

    public Pokemon(PokemonBuilder pokemonBuilder){
        this.pokemonName = pokemonBuilder.pokemonName;
        this.pokedexNumber = pokemonBuilder.pokedexNumber;
        this.gender = pokemonBuilder.gender;
        this.weight = pokemonBuilder.weight;
        this.height = pokemonBuilder.height;
        this.stats = pokemonBuilder.stats;
        this.generation = pokemonBuilder.generation;
        this.level = pokemonBuilder.level;
        this.moves = pokemonBuilder.moves;
        this.nickname = pokemonBuilder.nickname;
    }

}
