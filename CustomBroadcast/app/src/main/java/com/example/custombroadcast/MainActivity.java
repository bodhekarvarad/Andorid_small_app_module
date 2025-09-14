package com.example.custombroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String BROADCAST="mybroadcast";
    Myreceiver rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=new Myreceiver();
    }
    public void broadcast(View view)
    {
        Intent in=new Intent(MainActivity. BROADCAST);
        sendBroadcast(in);
    }
    protected void onResume()
    {
        super.onResume();
        IntentFilter inf=new IntentFilter(MainActivity.BROADCAST);
        registerReceiver(rec,inf);
    }
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(rec);
    }
    public class Myreceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Intent Detected",Toast.LENGTH_SHORT).show();
        }
    }


}