package com.example.nicolasartates.spinthebottle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ratings extends AppCompatActivity
{
    Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset_intent = new Intent(Ratings.this, MainActivity.class);
                startActivity(reset_intent);
            }
        });
    }
}
