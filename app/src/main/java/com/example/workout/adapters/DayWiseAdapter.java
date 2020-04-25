package com.example.workout.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.workout.ExerciseActivity;
import com.example.workout.R;
import com.example.workout.models.Exercise;

import java.util.List;

public class DayWiseAdapter extends RecyclerView.Adapter<DayWiseAdapter.ViewHolder> {

    List<Exercise> exerciseList;
    Context context;

    public DayWiseAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public DayWiseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise,parent,false);
        return new DayWiseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayWiseAdapter.ViewHolder holder, int position) {
          Exercise data = exerciseList.get(position);
          holder.textView.setText(data.getExercise_name());

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.gym_img)
                .error(R.drawable.gym_img);

        Context context = holder.imageView.getContext();
        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(data.getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.each_exercise);
            imageView=itemView.findViewById(R.id.exercise_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  Exercise eList = exerciseList.get(getAdapterPosition());
                    Intent intent = new Intent(context, ExerciseActivity.class);
                    intent.putExtra("image",eList.getImage());
                    intent.putExtra("exercise_name",eList.getExercise_name());
                    intent.putExtra("audio",eList.getAudio());
                    intent.putExtra("time",eList.getTime());
                    context.startActivity(intent);
                }
            });
        }
    }
}
