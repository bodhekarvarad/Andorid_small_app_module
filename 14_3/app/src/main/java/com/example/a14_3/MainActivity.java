package com.example.a14_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    String arr[] = new String[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = findViewById(R.id.gridview);
        for (int i = 0; i < 15; i++) {
            arr[i] = Integer.toString(i + 1);
        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,
                R.layout.pr, R.id.btn, arr);
        gridview.setAdapter(ad);
    }
}