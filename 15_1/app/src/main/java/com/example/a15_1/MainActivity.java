package com.example.a15_1;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn);
        btn2=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Simiple Toast",Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.customtoast,
                        findViewById(R.id.img));
                ImageView toastimg=layout.findViewById(R.id.img);
                TextView toasttxt=layout.findViewById(R.id.txt);
                TextView toasttxt2=layout.findViewById(R.id.txt1);
                toasttxt.setText("Message for you:\n");
                toasttxt2.setText("\nYou have got mail");
                toastimg.setImageResource(R.drawable.ic_android_black_24dp);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });


    }
}