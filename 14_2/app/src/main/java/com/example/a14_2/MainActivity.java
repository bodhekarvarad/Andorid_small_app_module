package com.example.a14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class MainActivity extends AppCompatActivity {

    public Button b1;
    public ImageView imgview;
    private boolean change = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        imgview = findViewById(R.id.imgview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (change) {
                    imgview.setImageResource(R.drawable.img);
                } else {
                    imgview.setImageResource(R.drawable.img_1);
                }
                change = !change;
            }
        });


    }
}