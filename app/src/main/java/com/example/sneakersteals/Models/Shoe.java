package com.example.sneakersteals.Models;

import java.util.List;

public class Shoe {
    String name, brand, description;
    int id;
    List<String> colourList, imageFilenameList;
    List<Integer> sizeList;

    public Shoe (String name, String brand, String description,
                 int id, List<String> colourList, List<String> imageFilenameList,
                 List<Integer> sizeList) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.id = id;
        this.colourList = colourList;
        this.imageFilenameList = imageFilenameList;
        this.sizeList = sizeList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getColourList() {
        return colourList;
    }

    public List<String> getImageFilenameList() {
        return imageFilenameList;
    }

    public List<Integer> getSizeList() {
        return sizeList;
    }
}
