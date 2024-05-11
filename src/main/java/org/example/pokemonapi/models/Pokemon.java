package org.example.pokemonapi.models;

import java.util.List;

public class Pokemon {

    private Integer id;
    private String name;
    private List<Types> types;
    private Sprite sprites;

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        nome = nome;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

}
