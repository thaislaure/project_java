package org.example.pokemonapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.pokemonapi.models.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    public Pagination listarPokemons(int limit, int off) throws IOException, InterruptedException {
        String uri = String.format("https://pokeapi.co/api/v2/pokemon/?limit=%s&offset=%s", limit, off);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Pagination data = new Gson().fromJson(response.body(), Pagination.class);

        var poke = data.getResults().stream().map(
                pokemon -> {
                    Pokemon pokemon1 = null;
                    PokemonReturn pokemonReturn = new PokemonReturn();
                    try {
                        pokemon1 = this.buscarPokemon(pokemon.getName());

                        pokemonReturn.setId(pokemon1.getId());
                        pokemonReturn.setName(pokemon1.getName());
                        pokemonReturn.setTypes(pokemon1.getTypes().stream().map(a -> new Name(a.getType().getName())).collect(Collectors.toList()));
                        pokemonReturn.setMiniature(pokemon1.getSprites().getFront_default());

                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return pokemonReturn;
                }
        ).toList();

        data.setResults(poke);
        return data;
    }

    public Pokemon buscarPokemon(String nome) throws IOException, InterruptedException {
        String uri = String.format("https://pokeapi.co/api/v2/pokemon/%s", nome);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        /*
        Gson gson = new Gson();
        return new Gson().fromJson(response.body(), Pokemon.class);
        */

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Pokemon.class);
    }

    public PokemonGet pokemon(String nome) throws IOException, InterruptedException {

        Pokemon pokemon1 = null;
        PokemonGet pokemonReturn = new PokemonGet();
        try {
            pokemon1 = this.buscarPokemon(nome);

            pokemonReturn.setId(pokemon1.getId());
            pokemonReturn.setName(pokemon1.getName());
            pokemonReturn.setAbilities(pokemon1.getAbilities());
            pokemonReturn.setImage(pokemon1.getSprites().getOther().getOfficialArtwork().getFrontDefault());
            pokemonReturn.setHeight(pokemon1.getHeight());
            pokemonReturn.setWeight(pokemon1.getWeight());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pokemonReturn;

    }

}
