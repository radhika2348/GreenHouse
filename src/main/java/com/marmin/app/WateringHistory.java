package com.marmin.app;

public class WateringHistory {
    private int wateredOn;
    private int wateredBy;

    public WateringHistory(int wateredOn, int wateredBy) {
        this.wateredOn = wateredOn;
        this.wateredBy = wateredBy;
    }

    public int getWateredOn(){
        return wateredOn;
    }

    public int getWateredBy(){
        return wateredBy;
    }

}
