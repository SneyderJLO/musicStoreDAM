package com.example.musicstore.model;

public class Instrument {
    private String name;
    private String description;
    private String brand;
    private int image;

    public Instrument(String name, String description, int image, String brand) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
