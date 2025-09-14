package com.example.sensors;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private boolean isColor = false;
    private long lastUpdate;
    RelativeLayout c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view.setBackgroundColor(Color.GREEN);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
        c=findViewById(R.id.main);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            float[] values = event.values;
            // Movement
            float x = values[0];
            float y = values[1];
            float z = values[2];
            float accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH *
                    SensorManager.GRAVITY_EARTH);
            long actualTime = System.currentTimeMillis();
            if (accelationSquareRoot >= 2) //it will be executed if you shuffle
            {
                if (actualTime - lastUpdate < 200) {
                    return;
                }
                lastUpdate = actualTime;
                if (isColor) {
                    c.setBackgroundColor(Color.GREEN);
                }
                else
                {

                    c.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(this, "shuffled", Toast.LENGTH_SHORT).show();
                }
                isColor = !isColor;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and accelerometer sensors
        sensorManager.registerListener((SensorEventListener) this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause() {
// unregister listener
        super.onPause(); sensorManager.unregisterListener((SensorEventListener) this);
    }
}
