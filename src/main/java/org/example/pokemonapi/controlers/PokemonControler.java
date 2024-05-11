package org.example.pokemonapi.controlers;

import org.example.pokemonapi.models.Pagination;
import org.example.pokemonapi.models.Pokemon;
import org.example.pokemonapi.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/pokemon/")
public class PokemonControler {

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping(value = "listar/{limit}/{off}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Pagination get(@PathVariable(value = "limit") int limit, @PathVariable(value = "off") int off) throws IOException, InterruptedException {
        return pokemonService.listarPokemons(limit, off);
    }

    @RequestMapping(value = "buscar/{nome}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Pokemon get(@PathVariable(value = "nome") String nome) throws IOException, InterruptedException {
        return pokemonService.buscarPokemon(nome);
    }

}
