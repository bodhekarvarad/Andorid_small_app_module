package com.example.a16_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TimePicker clock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clock=findViewById(R.id.clock);
        clock.setIs24HourView(true);

    }
}