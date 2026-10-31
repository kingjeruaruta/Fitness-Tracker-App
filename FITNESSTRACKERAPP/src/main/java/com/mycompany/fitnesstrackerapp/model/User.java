package com.mycompany.fitnesstrackerapp.model;

public class User {
    private int id;
    private String username;
    private String name;
    private Workout[] workouts = new Workout[0];
    private Meal[] meals = new Meal[0];

    public User() {
    }

    public User(int id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Workout[] getWorkouts() { return workouts; }
    public void setWorkouts(Workout[] workouts) {
        this.workouts = (workouts == null) ? new Workout[0] : workouts;
    }

    public Meal[] getMeals() { return meals; }
    public void setMeals(Meal[] meals) {
        this.meals = (meals == null) ? new Meal[0] : meals;
    }
}