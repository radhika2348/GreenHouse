package com.marmin.app;

import java.util.ArrayList;
import java.util.List;

class Plant {

    private int id;
    private String name;
    private String species;
    private int interval;
    private List<WateringHistory> wateringHistory = new ArrayList<>();

    Plant(int id, String name, String species, int interval) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.interval = interval;
    }

    public int getID() {
        return this.id;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public void water(int currentTime, int gardnerId) {
        wateringHistory.add(new WateringHistory(currentTime, gardnerId));
    }

    public List<WateringHistory> getWateringHistory() {
        return this.wateringHistory;
    }

    public boolean isDueForWatering(int currentTime) {
        boolean res;
        int lastWateredOn = wateringHistory.get(0).getWateredOn();
        for (int i = 0; i < wateringHistory.size(); i++) {
            if (lastWateredOn < wateringHistory.get(i).getWateredOn()) {
                lastWateredOn = wateringHistory.get(i).getWateredOn();
            }

        }

        res = currentTime >= lastWateredOn + interval;
        return res;
    }

    

   
}
