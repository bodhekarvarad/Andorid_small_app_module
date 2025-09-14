package com.example.batterylevel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView t1;
private BatteryBroadcastReceiver recv;
ProgressBar p1;
BroadcastReceiver b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        p1=findViewById(R.id.p1);
        recv=new BatteryBroadcastReceiver();

    }

    protected  void onStart()
    {
        registerReceiver(recv, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();

    }
    protected  void onStop()
    {

        unregisterReceiver(recv);
        super.onStop();


    }

    public class BatteryBroadcastReceiver  extends  BroadcastReceiver{
        public void onReceive(Context context,Intent intent)
        {
            int level =intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            t1.setText("Battery Level"+" :"+level);

            p1.setProgress(level);
if(level>=90)
{
    Toast.makeText(context, "Battery Full", Toast.LENGTH_SHORT).show();
    p1.setProgressTintList(ColorStateList.valueOf(Color.RED));
}
        else if(level<90 && level>=20)
            {
                Toast.makeText(context, "Battery Status Good", Toast.LENGTH_SHORT).show();

            }
        else {
            if(level<20 && level>5)
            {
                Toast.makeText(context, "Battery is low", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Battery is about to die", Toast.LENGTH_SHORT).show();
            }
        }


        }
    }

}