package com.example.pokeapi.service;

import com.example.pokeapi.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();

//    public Pokemon getPokemon(String name) {
//        String url = UriComponentsBuilder
//                .fromHttpUrl("https://pokeapi.co/api/v2/pokemon/" + name)
//                .toUriString();
//
//        var result = restTemplate.getForObject(url, java.util.Map.class);
//
//        if(result == null) return null;
//
//        Pokemon pokemon = new Pokemon();
//        pokemon.setName((String) result.get("name"));
//        pokemon.setId((int) result.get("id"));
//        pokemon.setWeight((double) result.get("weight"));
//        pokemon.setWon(false);
//        return pokemon;
//    }

    public Pokemon getPokemon(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();

        try {
            var result = restTemplate.getForObject(url, java.util.Map.class);
            if(result == null) return null;

            Pokemon pokemon = new Pokemon();
            pokemon.setName((String) result.get("name"));
            // A PokeAPI retorna "id" como Integer
            pokemon.setId(((Number) result.get("id")).intValue());
            // A PokeAPI retorna "weight" como Integer
            pokemon.setWeight(((Number) result.get("weight")).doubleValue());
            pokemon.setWon(false);
            Map<String, Object> sprites = (Map<String, Object>) result.get("sprites");
            pokemon.setImg((String) sprites.get("front_default"));

            return pokemon;
        } catch (org.springframework.web.client.HttpClientErrorException e) {
            // Pokémon não encontrado
            throw new RuntimeException("Pokémon não encontrado: " + name);
        }
    }


    /**
     * Swap between true or false
     *
     *
     */
    public Pokemon toggleWon(Pokemon p) {
        p.setWon(!p.isWon());
        return p;
    }
}
