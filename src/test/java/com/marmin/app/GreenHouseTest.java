package com.marmin.app;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

class GreenHouseTest {

    @Test
    void testPlantCareInitialization() {
        GreenHouse greenhouse = new GreenHouse();

        assertEquals(0, greenhouse.plants.getSize());
        assertEquals(0, greenhouse.gardeners.getLength());
        assertEquals(0, greenhouse.currentTime);
    }

    @Test
    void testAddPlant() {
        GreenHouse a = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");
        a.add(gardener1);

        Plant p1 = new Plant(1, "x", "y", 5);
        Plant p2 = new Plant(2, "x", "y", 6);

        a.add(p1, gardener1.getID());
        a.add(p2, gardener1.getID());
        assertEquals(2, a.plants.getSize());
        assertEquals(1, a.plants.getPlant(0).getID());
        assertEquals(2, a.plants.getPlant(1).getID());
        assertEquals("x", a.plants.getPlant(0).getName());
        assertEquals("x", a.plants.getPlant(1).getName());
        assertEquals("y", a.plants.getPlant(0).getSpecies());
        assertEquals("y", a.plants.getPlant(1).getSpecies());
        assertEquals(5, a.plants.getPlant(0).getInterval());
        assertEquals(6, a.plants.getPlant(1).getInterval());
        //TODO: assert that the newly added plants have been watered by checking the history
    }

    @Test
    void testAddGardeners() {

        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");

        greenHouse.add(gardener1);

        assertEquals(1, greenHouse.gardeners.getLength());
        assertEquals(1, greenHouse.gardeners.getGardener(0).getID());
        assertEquals("x", greenHouse.gardeners.getGardener(0).getName());

    }

    @Test
    void testInvalidPlantID() {

        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");

        greenHouse.add(gardener1);

        Plant plant = new Plant(-2, "x", "y", 8);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> greenHouse.plants.addPlant(plant));
        assertEquals("Provide valid arguments", exception.getMessage());
    }

    @Test
    void testDuplicatePlantID() {
        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");

        greenHouse.add(gardener1);

        Plant plant1 = new Plant(1, "x", "y", 5);
        Plant plant2 = new Plant(1, "x", "y", 5);

        greenHouse.add(plant1, gardener1.getID());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> greenHouse.plants.addPlant(plant2));
        assertEquals("Plant ID Exist", exception.getMessage());

    }

    @Test
    void testDuplicateGardenerID() {

        GreenHouse greenHouse = new GreenHouse();

        Gardener gardeners1 = new Gardener(1, "x");
        Gardener gardeners2 = new Gardener(1, "y");

        greenHouse.add(gardeners1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> greenHouse.gardeners.addGardeners(gardeners2));
        assertEquals("ID Exist", exception.getMessage());

    }

    @Test

    void testFindPlantsByItsID() {

        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");

        greenHouse.add(gardener1);

        Plant plants = new Plant(1, "X", "Y", 3);

        greenHouse.add(plants, gardener1.getID());

        assertSame(plants, greenHouse.plants.findPlantByID(1));
    }

    @Test

    void testFindNotExistingPlantByItsID() {

        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");

        greenHouse.add(gardener1);

        Plant plants = new Plant(1, "X", "Y", 3);

        greenHouse.add(plants, gardener1.getID());

        assertSame(null, greenHouse.plants.findPlantByID(2));
    }

    @Test
    void testFindPlantsToWaterAfterInitializingWillBeZero() {
        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");
        greenHouse.add(gardener1);

        Plant plant = new Plant(1, "X", "Y", 2);
        greenHouse.add(plant, gardener1.getID());

        List<Plant> duePlants = greenHouse.dueForWatering();
        assertEquals(0, duePlants.size());
    }

    @Test
    void testFindPlantsToWaterReturnsEmptyIfItIsNotDue() {
        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");
        greenHouse.add(gardener1);
        Plant plant = new Plant(1, "X", "Y", 2);
        greenHouse.add(plant, gardener1.getID());
        greenHouse.goToNextDay();

        List<Plant> duePlants = greenHouse.dueForWatering();
        
        assertEquals(0, duePlants.size());
    }


    @Test
    void testFindPlantsToWaterReturnsPlantIfItIsExactlyOnDueDay() {
        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");
        greenHouse.add(gardener1);
        Plant plant = new Plant(1, "X", "Y", 2);
        greenHouse.add(plant, gardener1.getID());
        greenHouse.goToNextDay();
        greenHouse.goToNextDay();

        List<Plant> duePlants = greenHouse.dueForWatering();
        
        assertEquals(1, duePlants.size());
    }


    @Test
    void testFindPlantsToWaterReturnsPlantIfItIsPastDueDay() {
        GreenHouse greenHouse = new GreenHouse();
        Gardener gardener1 = new Gardener(1, "x");
        greenHouse.add(gardener1);
        Plant plant = new Plant(1, "X", "Y", 2);
        greenHouse.add(plant, gardener1.getID());
        greenHouse.goToNextDay();
        greenHouse.goToNextDay();
        greenHouse.goToNextDay();

        List<Plant> duePlants = greenHouse.dueForWatering();
        
        assertEquals(1, duePlants.size());
    }
}
