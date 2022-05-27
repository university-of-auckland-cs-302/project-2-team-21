/*package com.example.sneakersteals;

import com.example.sneakersteals.Models.Shoe;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static Shoe generateShoe(int id) {
        String name, brand, description;
        List<String> colourList = null, imageFilenameList = null;
        List<Integer> sizeList = null;
        //This function will generate a shoe based on the id given. This will be manually filled out
        // with id = 1 as an example
        if (id == 1) {
            name = "Shoe 1";
            brand = "addidas";
            description = "placeholder description";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("image1.png");
            sizeList.add(8);
            sizeList.add(9);
            Shoe generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else {
            Shoe generatedShoe = null;
        }


        return generatedShoe;
    }


    public static List<Shoe> getShoes() {
        //This function will provide a list of generated shoe objects.
        List<Shoe> shoeList = new LinkedList<Shoe>();
        shoeList.add(generateShoe(1));
    }
}
*/