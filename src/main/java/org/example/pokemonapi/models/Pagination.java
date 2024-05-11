package org.example.pokemonapi.models;

import java.util.List;

public class Pagination {
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonReturn> getResults() {
        return results;
    }

    public void setResults(List<PokemonReturn> results) {
        this.results = results;
    }

    Integer count;
    String next;
    String previous;
    List<PokemonReturn> results;
}
