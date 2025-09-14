package com.example.from;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Grid_View extends AppCompatActivity {
    GridView gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gd=findViewById(R.id.gd);
        gd.setAdapter(new Img(this));

    }
}