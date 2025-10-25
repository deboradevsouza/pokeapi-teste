package com.example.pokeapi.model;

public class Pokemon {
    private String name;
    private int id;
    private double weight;
    private boolean won;
    private String img;

//    public Pokemon(String name, int id, double weight, boolean won, String img) {
//        this.name = name;
//        this.id = id;
//        this.weight = weight;
//        this.won = won;
//        this.img = img;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
