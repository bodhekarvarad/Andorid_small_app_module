package com.example.locationtracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText sourcrEdt,destinationEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sourcrEdt=findViewById(R.id.ed1);
        destinationEdt=findViewById(R.id.ed2);
    }

    public void Track(View view) {
        Uri uri= Uri.parse("https://www.google.co.in/maps/dir/"+sourcrEdt.getText().toString()+"/"+destinationEdt.getText().toString());
        Intent i=new Intent(Intent.ACTION_VIEW,uri);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }



}