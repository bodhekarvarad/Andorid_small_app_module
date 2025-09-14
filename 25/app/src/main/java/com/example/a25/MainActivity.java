package com.example.a25;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
    }

    public void Fade_in(View view) {
        Animation fin= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        img.startAnimation(fin);
    }

    public void Fade_out(View view) {
        Animation fout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        img.startAnimation(fout);
    }

    public void Zoom_In(View view) {
        Animation zin=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        img.startAnimation(zin);
    }

    public void Zoom_out(View view) {
        Animation zout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        img.startAnimation(zout);
    }
}