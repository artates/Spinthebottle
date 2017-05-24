package com.example.nicolasartates.spinthebottle;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Button button_back;

    Button button_sound;

    Button button_ratings;

    Boolean sound = true;

    Boolean ratings = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //back button
        button_back = (Button)findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //Intent back_intent = new Intent(Settings.this, Ratings.class);

                    //startActivity(back_intent);


                    Intent back_MA = new Intent(Settings.this, MainActivity.class);
                    back_MA.putExtra("settings_ratings", ratings);
                    back_MA.putExtra("sound_settings", sound);
                    startActivity(back_MA);

            }
        });


        final AudioManager AM;
        AM = (AudioManager)getSystemService(AUDIO_SERVICE);
        //sounds button
        button_sound = (Button)findViewById(R.id.button_sound);
        button_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound == true)
                {
                    //AM.setStreamMute(AudioManager.STREAM_SYSTEM, true);
                   // AM.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                   // AM.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                   // AM.setStreamMute(AudioManager.STREAM_ALARM, true);
                   // AM.setStreamMute(AudioManager.STREAM_RING, true);
                   // AM.setStreamMute(AudioManager.STREAM_MUSIC, true);
                   // AM.setStreamVolume(AudioManager.STREAM_SYSTEM, 0, 0);



                    sound = false;
                    soundbuttontoast();

                }
                else
                {
                    sound = true;
                    soundbuttontoastN();

                    //AM.setStreamMute(AudioManager.STREAM_SYSTEM, false);
                    //AM.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    //AM.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    //AM.setStreamMute(AudioManager.STREAM_ALARM, false);
                    //AM.setStreamMute(AudioManager.STREAM_RING, false);
                    //AM.setStreamMute(AudioManager.STREAM_MUSIC, false);

                }
            }
        });

        //ratings setting button
        button_ratings = (Button)findViewById(R.id.button_ratings);
        button_ratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ratings == true)
                {
                    ratings = false;
                    ratingsbuttontoastN();

                }
                else
                {
                    ratings = true;
                    ratingsbuttontoast();

                }
            }
        });

    }

    public Boolean getSound()
    {
        return sound;
    }
    public Boolean getRatings()
    {
        return ratings;
    }

    public void soundbuttontoast() { Toast.makeText(this, "You turned the sound off", Toast.LENGTH_SHORT).show();}
    public void soundbuttontoastN() { Toast.makeText(this, "You turned the sound on", Toast.LENGTH_SHORT).show();}
    public void ratingsbuttontoast() { Toast.makeText(this, "You turned the ratings page on", Toast.LENGTH_SHORT).show();}
    public void ratingsbuttontoastN() { Toast.makeText(this, "You turned the ratings page off", Toast.LENGTH_SHORT).show();}
}
