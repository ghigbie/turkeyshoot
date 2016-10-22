package com.geogehigbie.turkeyshoot;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import layout.FragmentOneBase;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialAnimation();

        loadFirstFrament();
    }

    // plays when the screen is open
    public void initialAnimation(){
        ImageView turkeybody = (ImageView) findViewById(R.id.turkey_body);
        TurkeyBig turkeyBig1 = new TurkeyBig(turkeybody, 2000, 2000, 2000, -2000, -1700, 1700, 4000, 0, 0, true);
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

    public void loadFirstFrament(){

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new FragmentOneBase());
        fragmentTransaction.commit();


    }



}
