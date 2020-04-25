package com.example.workout.models;

import java.util.List;

public class Day {

    private int id;
    private String day;
    private String title;
    private String time;
    private int image;


    public Day(int id,String day, String title, String time, int image) {
        this.id=id;
        this.day = day;
        this.title = title;
        this.time = time;
        this.image = image;


    }

    public Day(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
