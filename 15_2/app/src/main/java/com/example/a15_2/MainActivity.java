package com.example.a15_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;
public class MainActivity extends AppCompatActivity {

    private CheckBox checkbox1, checkbox2, checkbox3;
    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        orderButton = findViewById(R.id.orderButton);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOrder();
            }
        });
    }

    private void calculateOrder() {
        StringBuilder message = new StringBuilder("Selected items:\n");
        int total = 0;

        if (checkbox1.isChecked()) {
            message.append("Pizza 200Rs\n");
            total += 200;
        }
        if (checkbox2.isChecked()) {
            message.append("Coffee 50Rs\n");
            total += 50;
        }
        if (checkbox3.isChecked()) {
            message.append("Burger 120Rs\n");
            total += 120;
        }

        message.append("Total: " + total+"RS");

        Toast.makeText(this, message.toString(), Toast.LENGTH_LONG).show();
    }
}

