package com.example.batterylow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar Pb;
    TextView txt;
    BatteryBroadcastReciver recv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pb = findViewById(R.id.Pb);
        txt = findViewById(R.id.bl);
        recv = new BatteryBroadcastReciver();


    }
    @Override
    protected void onStart() {
        registerReceiver(recv, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();

    }
@Override
    protected void onStop() {
        unregisterReceiver(recv);
        super.onStop();
    }


protected class BatteryBroadcastReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
        txt.setText(level);
        Pb.setProgress(level);

    }
}

}