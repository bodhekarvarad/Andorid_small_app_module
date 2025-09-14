package com.example.print_3d_cooridinate;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView t1;
    SensorManager smg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.txt1);
        smg=(SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> l=smg.getSensorList(Sensor.TYPE_ACCELEROMETER);
        smg.registerListener(this,l.get(0),SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onSensorChanged(SensorEvent sensorEvent){
        float value[]= sensorEvent.values;
        t1.setText("x="+value[0]+" y="+value[1]+" z="+value[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}