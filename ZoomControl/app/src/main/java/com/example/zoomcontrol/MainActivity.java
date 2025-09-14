package com.example.zoomcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
        zoomControls=findViewById(R.id.zoomControl);
        zoomControls.hide();
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                zoomControls.show();
                return false;
            }
        });
        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=img.getScaleX();
                float y=img.getScaleY();
                img.setScaleX((float) (x+1));
                img.setScaleY((float) (y+1));
                Toast.makeText(getApplicationContext(), "Zoom In", Toast.LENGTH_SHORT).show();
                zoomControls.show();


            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=img.getScaleX();
                float y=img.getScaleY();
                img.setScaleX((float) (x-1));
                img.setScaleY((float) (y-1));
                Toast.makeText(getApplicationContext(),"Zoom Out",Toast.LENGTH_SHORT).show();
                zoomControls.show();
            }
        });


    }
}