package com.example.pokeapi.controller;

import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.service.PokemonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "API Pokémon funcionando!";
    }


    @GetMapping("/{name}")
    public Pokemon getPokemon(@PathVariable("name") String name) {
        return service.getPokemon(name);
    }

    @GetMapping("/{name}/setwon")
    public Pokemon toggleWonByQuery(@PathVariable("name") String name) {
        Pokemon p = service.getPokemon(name);
        if(p != null) {
        service.toggleWon(p);
        }

        return p;
    }
}
