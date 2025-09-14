package com.example.listallsensorindevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        sm= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList=sm.getSensorList(Sensor.TYPE_ALL);
        StringBuffer str=new StringBuffer();
        for(Sensor s:sensorList)
        {
            str.append(s.getName()).append("\n");

        }
        tv.setText(str);



    }
}