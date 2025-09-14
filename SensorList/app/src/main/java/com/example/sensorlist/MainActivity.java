package com.example.sensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sm;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text1);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> listS=sm.getSensorList(Sensor.TYPE_ALL);
        StringBuilder st=new StringBuilder();
        for(Sensor s:listS) {
            st.append(s.getName() + "\n");
        }
        t1.setText(st);
    }
}
