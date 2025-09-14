package com.example.a18_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b = getIntent().getExtras();
        int num=Integer.parseInt(b.getString("Num"));
        int fact =1;
        for(int i=1;i<=num;i++){
            fact=fact*i;
        }
        TextView t = findViewById(R.id.txt1);
        t.setText("Factorial = "+fact);
    }
}