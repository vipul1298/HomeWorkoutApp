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
import com.example.workout.R;
import com.example.workout.RandomActivity;
import com.example.workout.models.Exercise;
import com.example.workout.models.RandomExercise;

import java.util.List;
import java.util.Random;

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {

    List<RandomExercise> randomList;
    Context context;

    public RandomAdapter(List<RandomExercise> randomList, Context context) {
        this.randomList = randomList;
        this.context = context;
    }

    @NonNull
    @Override
    public RandomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_random,parent,false);
        return new RandomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomAdapter.ViewHolder holder, int position) {
        RandomExercise mData = randomList.get(position);
        holder.mTextView.setText(mData.getExercise_name());


        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.gym_img)
                .error(R.drawable.gym_img);

        Context context = holder.mImageView.getContext();
        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(mData.getImage())
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return randomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.rExercise_image);
            mTextView=itemView.findViewById(R.id.rEach_exercise);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RandomExercise rList = randomList.get(getAdapterPosition());
                    Intent intent = new Intent(context, RandomActivity.class);
                    intent.putExtra("r_image",rList.getImage());
                    intent.putExtra("r_exercise_name",rList.getExercise_name());
                    intent.putExtra("r_audio",rList.getAudio());
                    intent.putExtra("r_time",rList.getTime());
                    context.startActivity(intent);
                }
            });
        }
    }
}
