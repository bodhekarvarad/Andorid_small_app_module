package com.example.a18_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cal_show(View v){
        et=findViewById(R.id.et1);
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
        i.putExtra("Num",et.getText().toString());
        startActivity(i);
    }
}