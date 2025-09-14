package com.example.animation;

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
        img=findViewById(R.id.img1);

    }

    public void Bounce(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        img.startAnimation(anim);
    }

    public void StopAnimation(View view) {
       img.clearAnimation();

    }

    public void fadeout(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);
        img.startAnimation(anim);
    }

    public void fadein(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        img.startAnimation(anim);
    }

    public void Rotateanticlk(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotateanticlk);
        img.startAnimation(anim);
    }

    public void Rotateclk(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotateclk);
        img.startAnimation(anim);
    }

    public void Moveright(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.moveright);
        img.startAnimation(anim);
    }

    public void Moveleft(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.moveleft);
        img.startAnimation(anim);
    }

    public void Movedown(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.movedown);
        img.startAnimation(anim);
    }

    public void Moveup(View view) {
       Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.moveup);
        img.startAnimation(anim);}

    public void SlideRight(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideright);
        img.startAnimation(anim);
    }

    public void SlideLeft(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideleft);
        img.startAnimation(anim);
    }

    public void Slidedown(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slidedown);
        img.startAnimation(anim);
    }

    public void Slideup(View view) {
           Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideup);
        img.startAnimation(anim);
    }

    public void Zoomout(View view) {

           Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
        img.startAnimation(anim);
    }

    public void Zoomin(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
        img.startAnimation(anim);
    }

    public void Blink(View view) {
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        img.startAnimation(anim);
    }
}