package org.example.pokemonapi.models;

import java.util.List;

public class PokemonReturn {

    private Integer id;
    private String name;
    private List<Name> types;
    private String miniature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Name> getTypes() {
        return types;
    }

    public void setTypes(List<Name> name) {
        this.types = name;
    }

    public String getMiniature() {
        return miniature;
    }

    public void setMiniature(String miniature) {
        this.miniature = miniature;
    }
}