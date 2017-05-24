package com.example.nicolasartates.spinthebottle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{



    Boolean isReturned;
    //play button
    Button button_play;

    Boolean sounds = true;

    Boolean ratings = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //register sound
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.select);


        //setting

        //button onclicklistener
        button_play = (Button) findViewById(R.id.button_play);

        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fuck with this, sound boolean coming from settings or ratings, need to clean up settings
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    sounds = bundle.getBoolean("sound_settings");
                    ratings = bundle.getBoolean("settings_ratings");
                }


                if (sounds == true)
                {
                    mp.start();
                }
                Intent spin = new Intent(MainActivity.this, Spin.class);
                spin.putExtra("ratings", ratings);
                startActivity(spin);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_setting:
                Intent settings_intent = new Intent(MainActivity.this, Settings.class);
                startActivity(settings_intent);
                return true;

            case R.id.action_Rating:
                Intent ratings_intent = new Intent(MainActivity.this, Ratings.class);
                startActivity(ratings_intent);
                return true;

            default:
            return super.onOptionsItemSelected(item);
        }
    }
}