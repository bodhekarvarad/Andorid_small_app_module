package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void Start_Service(View view) {
        startService(new Intent(getApplicationContext(),MyService.class));
    }

    public void Stop_Service(View view) {
        stopService(new Intent(getApplicationContext(),MyService.class));
    }
}