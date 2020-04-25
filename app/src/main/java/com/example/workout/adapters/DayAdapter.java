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
import com.example.workout.DayWise;
import com.example.workout.R;
import com.example.workout.models.Day;

import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {

    public List<Day> dayList;
    Context context;

    public DayAdapter(List<Day> dayList, Context context) {
        this.dayList = dayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new DayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          Day data = dayList.get(position);
          holder.mday.setText(data.getDay());

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.gym_img)
                .error(R.drawable.gym_img);

          Context context = holder.mimage.getContext();
        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(data.getImage())
                .into(holder.mimage);

    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mday;
        public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mday=itemView.findViewById(R.id.each_day);
            mimage=itemView.findViewById(R.id.day_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Day dList = dayList.get(getAdapterPosition());
                    Intent intent = new Intent(context, DayWise.class);
                    intent.putExtra("id",dList.getId());
                    intent.putExtra("title",dList.getTitle());
                    intent.putExtra("time",dList.getTime());
                    intent.putExtra("image",dList.getImage());
                    context.startActivity(intent);
                }
            });
        }
    }
}
