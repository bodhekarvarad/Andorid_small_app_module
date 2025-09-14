package com.example.a20_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnToggleWifi;
    private boolean isWifiEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToggleWifi = findViewById(R.id.btnToggleWifi);
        btnToggleWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleWifiService();
            }
        });
    }

    private void toggleWifiService() {
        Intent wifiServiceIntent = new Intent(this, WifiStartService.class);
        if (!isWifiEnabled) {
            startService(wifiServiceIntent);
            isWifiEnabled = true;
            btnToggleWifi.setText("Turn Wi-Fi Off");
        } else {
            stopService(wifiServiceIntent);
            isWifiEnabled = false;
            btnToggleWifi.setText("Turn Wi-Fi On");
        }
    }
}
