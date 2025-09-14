package com.example.a10_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editTextName);
        Email = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);
    }

    public void register(View view) {
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        if (isValidInput(name, email, password)) {

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidInput(String name, String email, String password) {
        return !name.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }
}
