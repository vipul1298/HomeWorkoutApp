package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.workout.adapters.RandomAdapter;
import com.example.workout.models.Exercise;
import com.example.workout.models.RandomExercise;
import com.example.workout.utils.Days;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList extends AppCompatActivity {

    List<RandomExercise> mList = new ArrayList<>();
    RecyclerView mRecyclerList;
    Days days;
    RandomAdapter randomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_list);

        setTitle("Random-List");
        days = new Days();

        List<RandomExercise> randomExerciseList = getRandomElement(days.RANDOM_EXERCISE,5);

        for(RandomExercise r : randomExerciseList){
            mList.add(r);
        }

        mRecyclerList=findViewById(R.id.recycler_random);
        mRecyclerList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerList.setLayoutManager(layoutManager);

        randomAdapter=new RandomAdapter(mList,this);
        mRecyclerList.setAdapter(randomAdapter);

    }

    public List<RandomExercise> getRandomElement(List<RandomExercise> list,
                                           int totalItems)
    {
        Random rand = new Random();

        List<RandomExercise> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(list.size());
            // add element in temporary list
            newList.add(list.get(randomIndex));
            list.remove(randomIndex);
        }
        return newList;
    }
}
