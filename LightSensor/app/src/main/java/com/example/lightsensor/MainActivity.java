package com.example.lightsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView t1;
    SensorManager sm;
    MediaPlayer mp;
    Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text1);
        mp=MediaPlayer.create(this,R.raw.desires);
        sm=(SensorManager) getSystemService(Service.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    public void onResume(){
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onPause(){
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float intense=sensorEvent.values[0];
        t1.setText("Intensity : "+intense);

        if(intense>2000)
        {
            mp.pause();
        }else {
            mp.start();


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}