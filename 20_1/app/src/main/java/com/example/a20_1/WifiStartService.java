package com.example.a20_1;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.widget.Toast;

public class WifiStartService extends Service {

    private WifiManager wifiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startWifi();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopWifi();
    }

    private void startWifi() {
        if (wifiManager != null) {
            wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "Wi-Fi started", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to start Wi-Fi", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopWifi() {
        if (wifiManager != null) {
            wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "Wi-Fi stopped", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to stop Wi-Fi", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
