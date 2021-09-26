package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    TextView  text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView)findViewById(R.id.logo);
        text1 = (TextView)findViewById(R.id.text1);

        logo.animate().alpha(0f).setDuration(0);
        text1.animate().alpha(0f).setDuration(0);

       logo.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                text1.animate().alpha(1f).setDuration(800);
            }
        });
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(MainActivity.this, MainMenu.class);
               startActivity(intent);
               finish();
           }
       },3000);
    }
}