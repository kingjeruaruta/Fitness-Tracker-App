package com.mycompany.fitnesstrackerapp.model;

public class Workout {
    private int workoutId;
    private String name;
    private int duration;
    private double caloriesBurned;

    public Workout() {
    }

    public Workout(int workoutId, String name, int duration, double caloriesBurned) {
        this.workoutId = workoutId;
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public int getWorkoutId() { return workoutId; }
    public void setWorkoutId(int workoutId) { this.workoutId = workoutId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public double getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(double caloriesBurned) { this.caloriesBurned = caloriesBurned; }
}