package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.workout.adapters.DayAdapter;
import com.example.workout.models.Day;
import com.example.workout.utils.Days;

import java.util.ArrayList;
import java.util.List;

public class DayList extends AppCompatActivity {

    List<Day> mdayList = new ArrayList<>();
    RecyclerView recyclerView;
    DayAdapter dayAdapter;
    Days days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_list);

        setTitle("Day List");

        days = new Days();
        for(Day day : days.DAYS){
            mdayList.add(day);
        }
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dayAdapter = new DayAdapter(mdayList,this);
        recyclerView.setAdapter(dayAdapter);
    }
}
