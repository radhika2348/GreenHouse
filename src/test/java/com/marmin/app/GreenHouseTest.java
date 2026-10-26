package com.marmin.app;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

class GreenHouseTest {

    @Test
    void testPlantCareInitialization() {
        GreenHouse a = new GreenHouse();

        assertEquals(0, a.plants.size());//assertEquals(actua,expect);
        assertEquals(0, a.gardeners.size());
    }

    @Test
    void testAddGardener() {
        GreenHouse a = new GreenHouse();

        a.AddGardener(1, "Ram");

        assertEquals(1, a.gardeners.size());
        assertEquals("Ram", a.gardeners.get(0).getName());
        assertEquals(1, a.gardeners.get(0).getID());

    }

    @Test
    void testAddPlant() {
        GreenHouse a = new GreenHouse();

        a.AddPlant(1, "Rose", "Flower", 2);

        assertEquals(1, a.plants.size());
        assertEquals(1, a.plants.get(0).getID());
        assertEquals("Rose", a.plants.get(0).getName());
        assertEquals("Flower", a.plants.get(0).getSpecies());
        assertEquals(2, a.plants.get(0).getInterval());
    }

    @Test
    void testDuplicateGardernerID() {
        GreenHouse a = new GreenHouse();

        a.AddGardener(1, "Krish");

        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> a.AddGardener(1, "Ram"));
        assertEquals("Invalid", exception.getMessage());
    }

    @Test
    void testDuplicatePlantID() {
        GreenHouse a = new GreenHouse();

        a.AddPlant(1, "Rose", "Flower", 2);

        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> a.AddPlant(1, "Jasmine", "Flower", 2));
        assertEquals("Invalid", exception.getMessage());
    }

    @Test
    void testEmptyGardernerName() {
        GreenHouse a = new GreenHouse();

        a.AddGardener(1, "Krish");

        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> a.AddGardener(1, ""));
        assertEquals("Invalid", exception.getMessage());
    }

    @Test
    void testEmptyPlantID() {
        GreenHouse a = new GreenHouse();

       IllegalArgumentException exception= assertThrows(IllegalArgumentException.class, () -> a.AddPlant(1, "", "Flower", 2));
       assertEquals("Invalid", exception.getMessage());
    }

    @Test
    void testNegativePlantInterval() {
        GreenHouse a = new GreenHouse();

        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> a.AddPlant(1, "Rose", "Flower", -2));
        assertEquals("Invalid", exception.getMessage());
    }

    @Test
    void testEmptySpeciesName() {
        GreenHouse a = new GreenHouse();

       IllegalArgumentException exception= assertThrows(IllegalArgumentException.class, () -> a.AddPlant(1, "Rose", "", -2));
       assertEquals("Invalid", exception.getMessage());
    }

    @Test
    void testEmptyGardernerID() {
        GreenHouse a = new GreenHouse();

        //a.AddGardener(1, "Krish");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> a.AddGardener(-6, "w"));

        assertEquals("Invalid", exception.getMessage());
    }

}
