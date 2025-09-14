package com.example.a13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.*;

public class MainActivity extends AppCompatActivity {
    private Button B1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1=findViewById(R.id.button);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("File Downloading...");
                progressDialog.setMax(100);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i=0;
                        while(i<=100){
                            try{
                                progressDialog.setProgress(i);
                                i++;
                                Thread.sleep(200);
                            }catch (Exception e){

                            }
                        }
                    }
                }).start();
            }
        });
    }
}