package com.example.a17_par;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "IN Content View", Toast.LENGTH_LONG).show();
    }
    public void onStart() {
        super.onStart();
        toast("In Start");
    }

    public void onResume() {
        super.onResume();
      toast("In Resume");

    }
    public void onStop()
    {
        super.onStop();
        toast("In Stop");
    }
    public void onDestroy()
    {
        super.onDestroy();
        toast("In Destroy");
    }
    public void onPause()
    {
        super.onPause();
        toast("In Pause");
    }



    public void toast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

    }

}