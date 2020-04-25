package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.workout.adapters.DayAdapter;
import com.example.workout.adapters.DayWiseAdapter;
import com.example.workout.models.Exercise;
import com.example.workout.utils.Days;

import java.util.ArrayList;
import java.util.List;

public class DayWise extends AppCompatActivity {

    TextView mText,mTime;

    List<Exercise> exercises = new ArrayList<>();
    RecyclerView mRecycler;
    DayWiseAdapter dayWiseAdapter;
    Days days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_wise);

        mText=findViewById(R.id.muscle_group);
        mTime=findViewById(R.id.mtime);

        setTitle("Day-wise");

        Intent i = getIntent();
        int id = i.getIntExtra("id",0);
        String title = i.getStringExtra("title");
        String time =i.getStringExtra("time");
        int image = i.getIntExtra("image",0);

        mText.setText(title);
        mTime.setText("Max time: "+time+"mins");

        days = new Days();


        switch(id){
            case 0:
                for (Exercise e : days.MONDAY_EXERCISE) {
                    exercises.add(e);
                }
                break;
            case 1:
                for (Exercise e : days.TUESDAY_EXERCISE) {
                    exercises.add(e);
                }
                break;

            case 2:
                for (Exercise e : days.WEDNESDAY_EXERCISE) {
                    exercises.add(e);
                }
                break;

            case 3:
                for (Exercise e : days.THURSDAY_EXERCISE) {
                    exercises.add(e);
                }
                break;

            case 4:
                for (Exercise e : days.FRIDAY_EXERCISE) {
                    exercises.add(e);
                }
                break;

            case 5:
                for (Exercise e : days.SATURDAY_EXERCISE) {
                    exercises.add(e);
                }
                break;
        }

        mRecycler=findViewById(R.id.recyclerList);
        mRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);

        dayWiseAdapter = new DayWiseAdapter(exercises,this);
        mRecycler.setAdapter(dayWiseAdapter);
    }


}
