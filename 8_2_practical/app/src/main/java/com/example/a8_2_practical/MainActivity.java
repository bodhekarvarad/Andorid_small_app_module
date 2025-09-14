package com.example.a8_2_practical;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends AppCompatActivity {
    String[] subjects = {"22032 Entrepreneurship Development.","22060 Capstone Project execution & Report Writing.\n" +
            "22509 Management.\n",
            "22616 Programming With Python.\n",
            "22617 Mobile Application Development.\n",
            "22618 Emerging Trends In Computer And Information Technolgy."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, subjects);
        autoCompleteTextView.setAdapter(adapter);

    }
}