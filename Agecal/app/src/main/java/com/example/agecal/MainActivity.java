package com.example.agecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText birthYearEditText;
    Button calculateAgeButton;
    TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        birthYearEditText = findViewById(R.id.birthYearEditText);
        calculateAgeButton = findViewById(R.id.calculateAgeButton);
        ageTextView = findViewById(R.id.ageTextView);

        calculateAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int birthYear = Integer.parseInt(birthYearEditText.getText().toString());
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int age = currentYear - birthYear;
                ageTextView.setText("Your age is: " + age);


            }
        });
    }


}