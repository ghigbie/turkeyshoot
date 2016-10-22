package com.geogehigbie.turkeyshoot;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import layout.FragmentHorizonOne;
import layout.FragmentOneBase;
import layout.FragmentSkyPathOne;
import layout.FragmentSkyPathTwo;
import layout.FragmentTurkeyHeadFour;
import layout.FragmentTurkeyHeadOne;
import layout.FragmentTurkeyHeadThree;
import layout.FragmentTurkeyHeadTwo;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialAnimation();

        loadFirstFrament();

        loadGameFragments();
    }

    // plays when the screen is open
    public void initialAnimation(){
        ImageView turkeybody = (ImageView) findViewById(R.id.big_turkey_body);
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
        fragmentTransaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


    }

    public void loadGameFragments(){
        FragmentManager fragmentManagerGameSky1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameSky1 = fragmentManagerGameSky1.beginTransaction();

        fragmentTransactionGameSky1.add(R.id.sky_path1, new FragmentSkyPathOne());
        fragmentTransactionGameSky1.commit();

        FragmentManager fragmentManagerGameSky2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameSky2 = fragmentManagerGameSky2.beginTransaction();

        fragmentTransactionGameSky2.add(R.id.sky_path2, new FragmentSkyPathTwo());
        fragmentTransactionGameSky2.commit();

        FragmentManager fragmentManagerGameHorizon1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameHorizon1= fragmentManagerGameHorizon1 .beginTransaction();

        fragmentTransactionGameHorizon1.add(R.id.horizon, new FragmentHorizonOne());
        fragmentTransactionGameHorizon1.commit();

        FragmentManager fragmentManagerGameTurkeyHead1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameTurkeyHead1 = fragmentManagerGameTurkeyHead1.beginTransaction();

        fragmentTransactionGameTurkeyHead1.add(R.id.turkey_container1, new FragmentTurkeyHeadOne());
        fragmentTransactionGameTurkeyHead1.commit();

        FragmentManager fragmentManagerGameTurkeyHead2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameTurkeyHead2 = fragmentManagerGameTurkeyHead2.beginTransaction();

        fragmentTransactionGameTurkeyHead2.add(R.id.turkey_container2, new FragmentTurkeyHeadTwo());
        fragmentTransactionGameTurkeyHead2.commit();

        FragmentManager fragmentManagerGameTurkeyHead3 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameTurkeyHead3 = fragmentManagerGameTurkeyHead3.beginTransaction();

        fragmentTransactionGameTurkeyHead3.add(R.id.turkey_container3, new FragmentTurkeyHeadThree());
        fragmentTransactionGameTurkeyHead3.commit();

        FragmentManager fragmentManagerGameTurkeyHead4 = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionGameTurkeyHead4 = fragmentManagerGameTurkeyHead4.beginTransaction();

        fragmentTransactionGameTurkeyHead4.add(R.id.turkey_container4, new FragmentTurkeyHeadFour());
        fragmentTransactionGameTurkeyHead4.commit();

    }



}
