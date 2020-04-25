package com.example.workout.utils;

import com.example.workout.R;
import com.example.workout.models.Day;
import com.example.workout.models.Exercise;
import com.example.workout.models.RandomExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Days {

    public Day[] DAYS = {MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY};
//    public List[] EACH_DAY = new List[]{MONDAY_EXERCISE,TUESDAY_EXERCISE,WEDNESDAY_EXERCISE,THURSDAY_EXERCISE,FRIDAY_EXERCISE,SATURDAY_EXERCISE};



    public static final Day MONDAY = new Day(0,"Monday","Chest-Tricep","30", R.drawable.twelve);
    public static final Day TUESDAY = new Day(1,"Tuesday","Back-Bicep","30", R.drawable.ten);
    public static final Day WEDNESDAY = new Day(2,"Wednesday","Shoulder","30", R.drawable.thirteen);
    public static final Day THURSDAY = new Day(3,"Thursday","Chest-Tricep","30", R.drawable.eleven);
    public static final Day FRIDAY = new Day(4,"Friday","Back-Bicep","30", R.drawable.ten);
    public static final Day SATURDAY = new Day(5,"Saturday","Cardio-exercise","30", R.drawable.eight);

    public  List<Exercise> MONDAY_EXERCISE = new ArrayList<Exercise>(){{
        add(new Exercise("Wide Press-up",R.raw.joined_audio,"5",R.drawable.one));
        add(new Exercise("Diamond Press-up",R.raw.songrock,"5",R.drawable.one));
        add(new Exercise("One-arm Press-up",R.raw.song_rock_two,"5",R.drawable.one));
        add(new Exercise("Cross-over Box Press-up",R.raw.song_pop,"5",R.drawable.one));
        add(new Exercise("Close-grip Press-up",R.raw.songrock,"5",R.drawable.one));

    }};

    public  List<Exercise> TUESDAY_EXERCISE = new ArrayList<Exercise>(){{
        add(new Exercise("Single-Arm Dumbbell Rows",R.raw.up_from_the_ashes,"4",R.drawable.seven));
        add(new Exercise("Delt Raise",R.raw.song_pop,"4",R.drawable.ten));
        add(new Exercise("Bicep curl with resistance-band",R.raw.song_rock_two,"5",R.drawable.seven));
        add(new Exercise("Chin Up",R.raw.joined_audio,"4",R.drawable.ten));
        add(new Exercise("Bicep curl",R.raw.songrock,"5",R.drawable.seven));

    }};

    public  List<Exercise> WEDNESDAY_EXERCISE = new ArrayList<Exercise>(){{
                add(new Exercise("Plank raise tap crunch",R.raw.joined_audio,"4",R.drawable.one));
                add(new Exercise("Dumbbell lateral raise",R.raw.up_from_the_ashes,"4",R.drawable.thirteen));
                add(new Exercise("Reverse Fly",R.raw.song_rock_two,"4",R.drawable.thirteen));
                add(new Exercise("Military Press",R.raw.song_pop,"4",R.drawable.thirteen));
                add(new Exercise("Arnold Press",R.raw.songrock,"4",R.drawable.thirteen));

    }};

    public  List<Exercise> THURSDAY_EXERCISE = new ArrayList<Exercise>(){{
        add(new Exercise("Wide Press-up",R.raw.joined_audio,"5",R.drawable.one));
        add(new Exercise("Diamond Press-up",R.raw.songrock,"5",R.drawable.one));
        add(new Exercise("One-arm Press-up",R.raw.song_rock_two,"5",R.drawable.one));
        add(new Exercise("Cross-over Box Press-up",R.raw.song_pop,"5",R.drawable.one));
        add(new Exercise("Close-grip Press-up",R.raw.songrock,"5",R.drawable.one));
    }};

    public  List<Exercise> FRIDAY_EXERCISE = new ArrayList<Exercise>(){{
        add(new Exercise("Single-Arm Dumbbell Rows",R.raw.up_from_the_ashes,"4",R.drawable.seven));
        add(new Exercise("Delt Raise",R.raw.song_pop,"4",R.drawable.ten));
        add(new Exercise("Bicep curl with resistance-band",R.raw.song_rock_two,"5",R.drawable.seven));
        add(new Exercise("Chin Up",R.raw.joined_audio,"4",R.drawable.ten));
        add(new Exercise("Bicep curl",R.raw.songrock,"5",R.drawable.seven));
    }};

    public  List<Exercise> SATURDAY_EXERCISE = new ArrayList<Exercise>(){{
                add(new Exercise("Push-ups",R.raw.joined_audio,"4",R.drawable.one));
                add(new Exercise("Love Handles",R.raw.song_pop,"4",R.drawable.four));
                add(new Exercise("Lying Leg Curls",R.raw.song_rock_two,"4",R.drawable.eight));
                add(new Exercise("Crunches",R.raw.up_from_the_ashes,"4",R.drawable.two));
                add(new Exercise("Leg Raise",R.raw.songrock,"4",R.drawable.five));

    }};

    public  List<RandomExercise> RANDOM_EXERCISE = new ArrayList<RandomExercise>(){{
        add(new RandomExercise("Love Handles",R.raw.song_pop,"4",R.drawable.four));
        add(new RandomExercise("Lying Leg Curls",R.raw.song_rock_two,"4",R.drawable.eight));
        add(new RandomExercise("Crunches",R.raw.up_from_the_ashes,"4",R.drawable.two));
        add(new RandomExercise("Wide Press-up",R.raw.joined_audio,"4",R.drawable.one));
        add(new RandomExercise("Diamond Press-up",R.raw.songrock,"4",R.drawable.one));
        add(new RandomExercise("Chin Up",R.raw.joined_audio,"4",R.drawable.ten));
        add(new RandomExercise("Bicep curl",R.raw.songrock,"4",R.drawable.seven));
        add(new RandomExercise("Military Press",R.raw.song_pop,"4",R.drawable.thirteen));
        add(new RandomExercise("Arnold Press",R.raw.up_from_the_ashes,"4",R.drawable.thirteen));
        add(new RandomExercise("Close-grip Press-up",R.raw.song_rock_two,"4",R.drawable.one));
        add(new RandomExercise("Dumbell Push-up",R.raw.songrock,"4",R.drawable.six));

    }};

}
