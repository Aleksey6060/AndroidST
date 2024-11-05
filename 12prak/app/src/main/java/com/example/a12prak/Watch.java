package com.example.a12prak;

public class Watch {
    private String model;
    private String description;
    private int imageResource;

    public Watch(String model, String description, int imageResource) {
        this.model = model;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}