package com.example.a12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButtonGroup1, radioButtonGroup2;
    private Button showSelectedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.rgroup);
        radioButton1 = findViewById(R.id.r1);
        radioButton2 = findViewById(R.id.r2);
        radioButtonGroup1 = findViewById(R.id.rg1);
        radioButtonGroup2 = findViewById(R.id.rg2);
        showSelectedButton = findViewById(R.id.b1);

        showSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedText = "Selected: ";
                if (radioButton1.isChecked()) {
                    selectedText += radioButton1.getText() + " ";
                }
                if (radioButton2.isChecked()) {
                    selectedText += radioButton2.getText() + " ";
                }
                if (radioButtonGroup1.isChecked()) {
                    selectedText += radioButtonGroup1.getText() + " ";
                }
                if (radioButtonGroup2.isChecked()) {
                    selectedText += radioButtonGroup2.getText();
                }
                Toast.makeText(MainActivity.this, selectedText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}