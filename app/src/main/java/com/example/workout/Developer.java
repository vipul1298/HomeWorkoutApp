package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    TextView textView;
    Button lkd,insta,git;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        setTitle("About");

        textView=findViewById(R.id.link);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        lkd=findViewById(R.id.linkedin);
        insta=findViewById(R.id.instagram);
        git=findViewById(R.id.github);
        lkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link();
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insta();
            }
        });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                github();
            }
        });

    }

    private void insta(){
        Uri uri = Uri.parse("https://www.instagram.com/vipul.chaurasiya/?hl=en");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    private void link(){
        Uri uri = Uri.parse("https://in.linkedin.com/in/vipul-chaurasia-5a950a161");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    private void github(){
        Uri uri = Uri.parse("https://github.com/vipul1298");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
