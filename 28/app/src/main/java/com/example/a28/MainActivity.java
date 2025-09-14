package com.example.a28;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText user, pass;
    int loginAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        user = findViewById(R.id.e1);
        pass = findViewById(R.id.e2);
    }

    public void display(View view) {
        String email = user.getText().toString().trim();
        String password = pass.getText().toString().trim();
        if (email.equals("bodhekarvarad2004@gmail.com") &&
                password.equals("vb2004") && password.length() == 8 && !email.isEmpty()
                && !password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Login Successful",
                    Toast.LENGTH_SHORT).show();
            loginAttempts = 0;
        } else {
            loginAttempts++;
            if (loginAttempts >= 3) {
                btn.setEnabled(false);
                Toast.makeText(MainActivity.this, "Login Unsuccessfull\nToo many login attempts.\nTry again later.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login Unsuccessfull\nInvalid email or password.\nAttempts left: " + (3 -
                        loginAttempts), Toast.LENGTH_SHORT).show();
            }

        }
    }
}