package com.example.a21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver=new MyReceiver();


    }
    protected void onResume(){
        super.onResume();
        IntentFilter fe=new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        Intent intent = registerReceiver(receiver, fe);

    }
protected void onDestroy()
{
    super.onDestroy();
    unregisterReceiver(receiver);

}

}

