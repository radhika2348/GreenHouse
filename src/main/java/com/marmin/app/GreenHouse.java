package com.marmin.app;

import java.util.List;

class GreenHouse {

    Plants plants = new Plants();
    Gardeners gardeners = new Gardeners();
    int currentTime = 0;

    public void add(Plant obj, int gardnerId) {
        plants.addPlant(obj);
        plants.waterPlant(obj.getID(), currentTime, gardnerId);
    }

    public void add(Gardener obj) {
        gardeners.addGardeners(obj);
    }

    public List<Plant> dueForWatering() {
        return plants.dueForWatering(currentTime);
    }

    public void water(int id, int gardnerId) {
        plants.waterPlant(id, currentTime, gardnerId);
    }

    public void goToNextDay() {
        currentTime++;
    }
}
