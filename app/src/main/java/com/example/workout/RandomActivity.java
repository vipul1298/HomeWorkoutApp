package com.example.workout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    ImageView ranImage;
    TextView ranExercise,ranTime,ran_timer;
    Button start_btn;
    MediaPlayer mPlayer;
    AudioCount audioCount;
    RestCounter restCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        ranImage=findViewById(R.id.rEx_image);
        ranExercise=findViewById(R.id.rEx_title);
        ranTime=findViewById(R.id.rtime);
        ran_timer=findViewById(R.id.random_countdown);
        start_btn=findViewById(R.id.random_start_button);

        setTitle("RandomExercise");

        Intent i = getIntent();
        String title = i.getStringExtra("r_exercise_name");
        String time = i.getStringExtra("r_time");
        int image = i.getIntExtra("r_image",0);
        final int audio = i.getIntExtra("r_audio",0);

        int mTime = Integer.parseInt(time);
        mTime=mTime*60*1000;

        ranExercise.setText(title);
        ranTime.setText(time+" mins");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.gym_img)
                .error(R.drawable.gym_img);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions)
                .load(image)
                .into(ranImage);

        final int finalMTime = mTime;

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer = new MediaPlayer();
                mPlayer=MediaPlayer.create(getApplicationContext(),audio);
                mPlayer.setLooping(true);
                mPlayer.start();
                audioCount = new AudioCount(finalMTime,1000);
                audioCount.start();
                Toast.makeText(RandomActivity.this, "Started..", Toast.LENGTH_SHORT).show();

            }
        });
    }

   public class AudioCount extends CountDownTimer {

       public AudioCount(long millisInFuture, long countDownInterval) {
           super(millisInFuture, countDownInterval);
       }

       @Override
       public void onTick(long l) {

       }

       @Override
       public void onFinish() {
           if(mPlayer.isPlaying()){
               mPlayer.stop();
               mPlayer.release();
           }
           restCounter = new RestCounter(40000,1000);
           restCounter.start();
       }
   }

   public class RestCounter extends CountDownTimer {

       public RestCounter(long millisInFuture, long countDownInterval) {
           super(millisInFuture, countDownInterval);
       }

       @Override
       public void onTick(long l) {
           int ans = (int) l/1000;
           ran_timer.setVisibility(View.VISIBLE);
           ran_timer.setText("Take rest for "+ans+" secs");
       }

       @Override
       public void onFinish() {
           ran_timer.setVisibility(View.INVISIBLE);
       }
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.info_two,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.inform:
                information();
                return true;
        }
        return false;
    }

    private void information() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(R.string.info)
                .setTitle("Information")
                .setCancelable(false)
                .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        dialog.show();
    }
}
