package com.example.sneakersteals.Models;

import java.util.List;

public class Shoe {
    String name, brand, description;
    List<String> colourList, imageFilenameList;
    List<Integer> sizeList;
    int viewCount;

    public Shoe (String name, String brand, String description,
                 List<String> colourList, List<String> imageFilenameList,
                 List<Integer> sizeList) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.colourList = colourList;
        this.imageFilenameList = imageFilenameList;
        this.sizeList = sizeList;
        this.viewCount = 0;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void incrementViewCount() {
        this.viewCount++;
    }
}
