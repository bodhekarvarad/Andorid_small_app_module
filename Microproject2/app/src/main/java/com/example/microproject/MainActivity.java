package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mpBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mpBackground = MediaPlayer.create(this, R.raw.background_music);
        mpBackground.start();
    }

    public void startGame(View view) {
        GameView gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mpBackground != null && mpBackground.isPlaying()) {
            mpBackground.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mpBackground != null && !mpBackground.isPlaying()) {
            mpBackground.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpBackground != null) {
            mpBackground.stop();
            mpBackground.release();
        }
    }
}
