package com.example.workout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Timer;
import java.util.TimerTask;

public class ExerciseActivity extends AppCompatActivity {

    ImageView fImage;
    TextView fExercise,fTime,timer;
    Button start_btn;
    MediaPlayer mediaPlayer;
    MyCount counter;
    RestCount restCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        setTitle("Exercise");


        fImage=findViewById(R.id.ex_image);
        fExercise=findViewById(R.id.ex_title);
        fTime=findViewById(R.id.mtime);
        start_btn=findViewById(R.id.start_button);
        timer=findViewById(R.id.countdown);

        Intent i = getIntent();
        String title = i.getStringExtra("exercise_name");
        String time = i.getStringExtra("time");
        int image = i.getIntExtra("image",0);
        final int audio = i.getIntExtra("audio",0);

        int mTime = Integer.parseInt(time);
        mTime=mTime*60*1000;

        fExercise.setText(title);
        fTime.setText(time+" mins");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.gym_img)
                .error(R.drawable.gym_img);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions)
                .load(image)
                .into(fImage);


        final int finalMTime = mTime;

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer=MediaPlayer.create(getApplicationContext(),audio);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                counter = new MyCount(finalMTime,1000);
                counter.start();
                Toast.makeText(ExerciseActivity.this, "Started..", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.info,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.infomation:
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

    public class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            restCount = new RestCount(40000,1000);
            restCount.start();
        }


        @Override
        public void onTick(long millisUntilFinished) {

        }
    }

    public class RestCount extends CountDownTimer{

        public RestCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
           int ans = (int) l/1000;
           timer.setVisibility(View.VISIBLE);
           timer.setText("Take rest for "+ans+" secs");
        }

        @Override
        public void onFinish() {
           timer.setVisibility(View.INVISIBLE);
        }
    }


}
