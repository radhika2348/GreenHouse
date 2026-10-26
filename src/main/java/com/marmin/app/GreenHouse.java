package com.marmin.app;

import java.util.ArrayList;
import java.util.*;

class Plant {

    //instance variables
    private int id;
    private String name;
    private String species;
    private int interval;

    Plant(int id, String name, String species, int interval) {
        
        if (id < 0 || name.isBlank() || species.isBlank() || interval < 0) {
            throw new IllegalArgumentException("Invalid");

        }
        //initializitng the instance variables
        this.id = id;
        this.name = name;
        this.species = species;
        this.interval = interval;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getInterval() {
        return this.interval;
    }

    

}

class Gardener {

    private int id;
    private String name;
    int num=10;

    Gardener(int id, String name) {

        if (id < 0 || name.isBlank()) {
            throw new IllegalArgumentException("Invalid");
        }

        this.id = id;
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    
     public static void displayGardener(){
       Gardener g=new Gardener(1,"num");
        System.out.println(g.getName());
    }


}

class GreenHouse {

    List<Plant> plants = new ArrayList<Plant>();
    List<Gardener> gardeners = new ArrayList<Gardener>();

    public void AddGardener(int ID, String Name) {
        for (int i=0;i<gardeners.size();i++) {
            if (gardeners.get(i).getID() == ID) {
                throw new IllegalArgumentException("Invalid");
            }

        }
        Gardener gardener1 = new Gardener(ID, Name);

        gardeners.add(gardener1);
    }

    public void AddPlant(int id, String name, String species, int interval) {
        for (int i=0;i<plants.size();i++) {
            if (plants.get(i).getID() == id) {
                throw new IllegalArgumentException("Invalid");
            }

        }
        Plant plant1 = new Plant(id, name, species, interval);
        plants.add(plant1);

    }

    
    public  void displayPlants(){
      for (int i=0;i<plants.size();i++){
          System.out.println(plants.get(i));
          
      }
    }
    
    public void displayGardener(){
        for(int i=0;i<gardeners.size();i++){
            System.out.println(gardeners.get(i));
        }
    }


}
