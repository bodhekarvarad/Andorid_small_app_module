package com.example.bindservice;
import com.example.bindservice.MyService.MyService1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    MyService ms=new MyService();
    boolean flags=false;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent(getApplicationContext(),MyService.class);
        bindService(i,servcon, Context.BIND_AUTO_CREATE);
        tv=findViewById(R.id.txt);

    }
    protected ServiceConnection servcon=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService1 binder=(MyService1)service;
            ms=binder.getService();
            flags=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            flags=false;
        }
    };

    public void Get(View view) {
        tv.setText("Current time and data:"+ms.GetTime());
    }
}