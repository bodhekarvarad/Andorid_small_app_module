package com.example.a27;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Btn;
    EditText e1, e2;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn = findViewById(R.id.btn);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
    }

    public void display(View V) {
        String t1 = e1.getText().toString();
        String t2 = e2.getText().toString();
        if (t1.equals("bodhekarvarad2004") && t2.equals("6P")) {
            Toast.makeText(MainActivity.this, "Login SuccessFull",
                    Toast.LENGTH_SHORT).show();
        } else {
            count++;
            if (count == 3) {
                Btn.setEnabled(false);
            }
            Toast.makeText(MainActivity.this, "Login UnSuccessFull",
                    Toast.LENGTH_SHORT).show();
        }
    }
}