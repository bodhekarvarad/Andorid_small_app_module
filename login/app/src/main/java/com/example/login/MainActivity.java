package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String id="shailesh";
    String password="123";
    EditText uname,pass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
    }

    public void login(View v)
    {
        String ide= uname.getText().toString();
        String passe= pass.getText().toString();

        if(id.equals(ide)&&password.equals(passe))
        {
            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_SHORT).show();
        }
    }
}