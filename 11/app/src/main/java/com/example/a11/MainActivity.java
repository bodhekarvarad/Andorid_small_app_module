package com.example.a11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox1, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage();
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage();
            }
        });
    }

    private void displayMessage() {
        StringBuilder message = new StringBuilder();

        if (checkBox1.isChecked()) {
            message.append("PWP\n");
        }

        if (checkBox2.isChecked()) {
            message.append("MGT\n");
        }

        if (message.length() == 0) {
            message.append("No checkboxes selected");
        }

        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
    }
}
