package com.example.sensorshullped;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Service;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor s;
    LinearLayout ll;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm=(SensorManager) getSystemService(Service.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    public void onResume(){
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onPause()
    {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float value[]=sensorEvent.values;
        float x=value[0];
        float y=value[1];
        float z=value[2];
        ll=findViewById(R.id.ll);
        if(x*y*z<=50){
            ll.setBackgroundColor(Color.GREEN);
        }else if(x*y*z<=100 && x*y*z>50){
            Toast.makeText(this, "Change", Toast.LENGTH_SHORT).show();
            ll.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}