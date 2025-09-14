package com.example.a9_1_practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb1,tb2;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb1=findViewById(R.id.tog1);
        tb2=findViewById(R.id.tog2);
        sub=findViewById(R.id.btn);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "ToggleButton1 : " + tb1.getText() + "\n" + "ToggleButton2 : " +tb2.getText();
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        });
    }
}