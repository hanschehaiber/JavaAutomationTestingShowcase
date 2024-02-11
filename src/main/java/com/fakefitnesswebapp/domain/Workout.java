package com.fakefitnesswebapp.domain;

import java.util.List;

public class Workout {
    private String name;
    private String date;
    private List<Exercise> exercises;

    public Workout(){}
    public Workout(String name, String date, List<Exercise> exercises) {
        this.name = name;
        this.date = date;
        this.exercises = exercises;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", exercises=" + exercises +
                '}';
    }
}
