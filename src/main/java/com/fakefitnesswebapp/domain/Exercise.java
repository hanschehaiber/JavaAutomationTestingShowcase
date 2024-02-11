package com.fakefitnesswebapp.domain;

public class Exercise {
    private String name;
    private int reps;
    private int weight;
    private String description;

    public Exercise(){};
    public Exercise(String name, int reps, int weight, String description) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", reps=" + reps +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}


