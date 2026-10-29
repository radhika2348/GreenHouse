package com.marmin.app;

class Gardener {

    private int id;
    private String name;

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

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

}
