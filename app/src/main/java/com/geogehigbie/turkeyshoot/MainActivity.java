package com.geogehigbie.turkeyshoot;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialAnimation();
    }

    public void initialAnimation(){
        ImageView turkeybody = (ImageView) findViewById(R.id.turkey_body);
        TurkeyBig turkeyBig1 = new TurkeyBig(turkeybody, 2000, 2000, 2000, -2000, -1700, 1700, 4000, 0, 0, false);
        turkeyBig1.translateAninimation(turkeybody);

        playInitialGobble();

    }

    public void playInitialGobble(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.turkey_gobble);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);

    }

    public void playSoundEffects(){

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_on_sound);
        mediaPlayer.start();

    }



}
