package com.example.nicolasartates.spinthebottle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Spin extends AppCompatActivity {

    //bottle Image view
    ImageView imgView_bottle;

    //Go button
    Button button_GO;

    //create random number for rotation
    Random r;

    boolean breturn;

    Button button_back;
    Boolean rating;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);

        final MediaPlayer spin = MediaPlayer.create(this, R.raw.bottlespin);

        button_back = (Button)findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                rating = bundle.getBoolean("ratings");
                if (rating == true) {

                    Intent back_intent = new Intent(Spin.this, Ratings.class);
                    startActivity(back_intent);
                }
                else
                {
                    Intent MA = new Intent(Spin.this, MainActivity.class);
                    startActivity(MA);
                }

            }
        });


        //registering
        r= new Random();

        //register button and image view
        imgView_bottle = (ImageView) findViewById(R.id.imgView_bottle);

        button_GO = (Button)findViewById(R.id.button_GO);

        button_GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotate = new RotateAnimation(0,r.nextInt(3600)+3600,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f );
                rotate.setFillAfter(true);
                rotate.setDuration(3000);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                imgView_bottle.startAnimation(rotate);

                spin.start();


            }
        });

        breturn = true;

    }


    public boolean getReturn()
    {
        return breturn;
    }
}
