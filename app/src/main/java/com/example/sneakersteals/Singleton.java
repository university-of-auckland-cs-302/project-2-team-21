package com.example.sneakersteals;

import com.example.sneakersteals.Models.Shoe;

public class Singleton {
    private static Singleton instance = null;
    public DataProvider database = new DataProvider();
    protected Singleton() {
        // Exists only to defeat instantiation.
    }
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public DataProvider getDatabase() {
        return database;
    }
    public void incrementViewCount(Shoe currentShoe) {
        database.shoeList.get(database.shoeList.indexOf(currentShoe)).incrementViewCount();
    }
}
