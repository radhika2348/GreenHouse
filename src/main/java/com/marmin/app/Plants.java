package com.marmin.app;

import java.util.ArrayList;
import java.util.List;

class Plants {

    private Plant[] elements = new Plant[0];

    private int count;

    public Plants() {

    }

    public Plant getPlant(int index) {
        return elements[index];
    }

    

    public int getSize() {
        return elements.length;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(elements[i]);
        }
    
    }

    public Plant findPlantByID(int id) {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Empty");
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getID() == id) {
                return elements[i];
            }

        }
        return null;
    }

    public void addPlant(Plant obj) {

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getID() == obj.getID()) {
                throw new IllegalArgumentException("Plant ID Exist");
            }
        }

        if (obj.getID() < 0 || obj.getName().isBlank() || obj.getSpecies().isBlank() || obj.getInterval() < 0) {
            throw new IllegalArgumentException("Provide valid arguments");
        }
        int newcapacity = elements.length + 1;

        Plant[] newElements = new Plant[newcapacity];
        for (int i = 0; i < count; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        elements[count] = obj;

        count++;
    }

    public void waterPlant(int plantId, int currentTime, int gardnerId) {
        Plant plant = findPlantByID(plantId);
        plant.water(currentTime, gardnerId);
    }

   

    public void display() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    public List<Plant> dueForWatering(int currentTime) {
        var duePlants = new ArrayList<Plant>();
        // Find all the plants/elements who are yet to be watered by looping through the elements.
         for (int i = 0; i < elements.length; i++) {
        if (elements[i].isDueForWatering(currentTime)) {
            duePlants.add(elements[i]);
        }
    }
        
        return duePlants;
    }
}
