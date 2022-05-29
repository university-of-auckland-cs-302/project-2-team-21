package com.example.sneakersteals;

import com.example.sneakersteals.Models.Shoe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static Shoe generateShoe(int id) {
        String name, brand, description;
        List<String> colourList = new ArrayList<>(), imageFilenameList = new ArrayList<>();
        List<Integer> sizeList = new ArrayList<>();
        Shoe generatedShoe = null;

        //This function will generate a shoe based on the id given. This will be manually filled out
        // with id = 1 as an example
        if (id == 1) {
            name = "Shoe 1";
            brand = "Addidas";
            description = "placeholder description";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 2) {
            name = "Shoe 2";
            brand = "Nike";
            description = "placeholder description";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 3) {
            name = "Shoe 3";
            brand = "Nike";
            description = "placeholder description 3";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 4) {
            name = "Shoe 4";
            brand = "Nike";
            description = "placeholder description 4";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 5) {
            name = "Shoe 5";
            brand = "Nike";
            description = "placeholder description 5";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 6) {
            name = "Shoe 6";
            brand = "Nike";
            description = "placeholder description 6";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }  else if (id == 7) {
            name = "Shoe 7";
            brand = "Nike";
            description = "placeholder description 7";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 8) {
            name = "Shoe 8";
            brand = "Nike";
            description = "placeholder description 8";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }
        else if (id == 9) {
            name = "Shoe 9";
            brand = "Nike";
            description = "placeholder description 9";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }
        else if (id == 10) {
            name = "Shoe 10";
            brand = "Nike";
            description = "placeholder description 10";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("shoes");
            sizeList.add(8);
            sizeList.add(9);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }


        return generatedShoe;
    }


    public static List<Shoe> getShoes() {
        //This function will provide a list of generated shoe objects.
        List<Shoe> shoeList = new LinkedList<Shoe>();
        shoeList.add(generateShoe(1));
        shoeList.add(generateShoe(2));


        return shoeList;
    }

    public static List<Shoe> getBrandShoes(String brand) {
        //This function will provide a list of generated shoe objects.
        List<Shoe> shoeList = new LinkedList<Shoe>();
        for (int i = 1; i < 11 ; i++) {
            Shoe currentShoe = generateShoe(i);
            if (currentShoe.getBrand().equals(brand)) {
                shoeList.add(currentShoe);
            }
        }


        return shoeList;
    }

    public static List<Shoe> getSearchShoes(String input) {
        List<Shoe> shoeList = new LinkedList<Shoe>();
        input.toLowerCase();
        for (int i = 1; i < 11 ; i++) {
            Shoe currentShoe = generateShoe(i);
            if (currentShoe.getName().toLowerCase().contains(input)) {
                shoeList.add(currentShoe);
            }
        }
        return shoeList;
    }

    public static Shoe getOneShoe(String nameInput) {
        for (int i = 1; i < 11 ; i++) {
            Shoe currentShoe = generateShoe(i);
            if (currentShoe.getName().equals(nameInput)) {
                return currentShoe;
            }
        }
        return null;
    }

    public static List<Shoe> getTopPicks(String input) {
        List<Shoe> shoeList = new LinkedList<Shoe>();
        input.toLowerCase();
        for (int i = 1; i < 11 ; i++) {
            Shoe currentShoe = generateShoe(i);

            shoeList.add(currentShoe);

        }
        return shoeList;
    }
}