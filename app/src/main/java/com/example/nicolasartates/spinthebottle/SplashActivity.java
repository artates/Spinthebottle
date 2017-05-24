package com.example.nicolasartates.spinthebottle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity
{
    final static int time_splash = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash_intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splash_intent);
                finish();



            }
        },time_splash );
    }
}
