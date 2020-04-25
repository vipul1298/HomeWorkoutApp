package com.example.workout.models;

public class RandomExercise {
    String exercise_name;
    int audio;
    String time;
    int image;

    public RandomExercise(String exercise_name, int audio, String time, int image) {
        this.exercise_name = exercise_name;
        this.audio = audio;
        this.time = time;
        this.image = image;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
