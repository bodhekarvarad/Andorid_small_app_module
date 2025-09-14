package com.example.mediaplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer MP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MP=MediaPlayer.create(this,R.raw.song);
    }
    public void musicPlay(View v)
    {

        MP.start();
    }
    public void musicPause(View v)
    {

MP.pause();
    }
    public void musicStop(View v)
    {
    MP.stop();

    MP=MediaPlayer.create(this,R.raw.song);

    }
}
